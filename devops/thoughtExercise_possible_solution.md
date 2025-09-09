# Part 1 — Initial setup (10 clients, single server)

## 1) Subdomains & per-client React + API

**DNS & TLS**

* Create DNS records: either **A/AAAA per client** (`client1.yourdomain.com`) to your server IP, *or* a **wildcard CNAME** `*.yourdomain.com` → `app.yourdomain.com`.
* Issue a **wildcard TLS cert** (`*.yourdomain.com`) or individual certs via Let’s Encrypt. Ensure your web server supports **SNI**.

  * Edge case: Let’s Encrypt HTTP-01 must route `/.well-known` correctly for each subdomain; consider DNS-01 for wildcard.

**Web server (e.g., Nginx/Apache)**

* One **server block** that catches `*.yourdomain.com` and **routes React static files**.
* React build options:

  * **Single build, runtime-configurable**: serve the same static assets for all clients, inject per-client config via `/config/{client}.json` fetched at runtime (preferred).
  * **Per-client build**: separate build folder per client (heavier; easy to mismatch versions).
* **Reverse proxy** `/api` → Node.js backend on localhost\:PORT.

**Backend**

* Resolve client from **host header** (`client1.yourdomain.com`). Normalize and validate the tenant ID.
* Load client config from a **config store** (YAML/JSON files on disk, or a small DB table). Cache briefly (e.g., 60s).
* Keep backend **stateless**; store sessions in Redis if you must use sessions (avoid sticky sessions later).

## Managing per-client variations (branding, endpoints)

* Maintain a **clients/ directory**:

  * `clients/client-id/config.json` (API base, feature flags, region, SLA tier)
  * `clients/client-id/theme.json` (colors, logo URLs, text)
* Manual process per client:

  1. Add/modify `config.json` + `theme.json`.
  2. Upload client logo to `/assets/clients/{client}/logo.*`.
  3. If using runtime config, **no rebuild**; otherwise run `npm run build:{client}`.
  4. Update web server mapping if per-client build folders are used.
  5. **Smoke test** (see checklist below).
* Keep a **CHANGELOG.md per client** to track tweaks; store everything in git for rollback.

## Risks & verification

* **Risks**: DNS propagation lag; cert issuance failures; wrong tenant inferred from host; stale caches; CORS/cookie domain mistakes; branding drift.
* **Verify** with a **manual checklist**:

  * DNS resolves → TLS valid → homepage loads → `/config/<client>.json` matches expected → API `/health?tenant=<auto>` returns OK and tenant=expected → critical flows (login, list, create) pass → branding visible.
* Use a **scripted curl suite** that loops over all 10 subdomains and checks status + simple JSON assertions.

---

# Part 2 — Scaling up (100 clients, multiple servers)

## 1) Frontend across multiple servers + load balancing

**Routing**

* Put a **load balancer (LB)** in front (HAProxy/Nginx/Cloud LB). DNS: point each subdomain (or wildcard) to the LB.
* All frontend servers serve **identical static assets**; rely on **runtime `/config/{client}.json`** to avoid N×M builds.

**Updating without downtime**

* **Blue/Green** at the LB:

  * Stage new assets on **Green** pool (servers B).
  * Flip LB to Green; keep **immutable asset filenames** (content-hashed) to avoid cache poisoning.
* **Canary** for safety: route 1–5% traffic to new pool first.
* **Cache headers**: `Cache-Control: public, max-age=31536000, immutable` for hashed assets; short TTL for `/config/*.json`.
* **Edge cases**: clients behind restrictive proxies caching `/config`; append `?v=timestamp` to runtime config fetch.

## 2) Backend scaling + LB

**Manual scaling**

* Start more Node.js instances (PM2/systemd) on each app server; put **an internal LB** (Nginx/HAProxy) in front, and a **public LB** in front of all app servers.
* Ensure **health checks** verify *tenant resolution* and *critical dependencies* (DB/Redis).

**Correct client config on every instance**

* Store client configs in a **shared source of truth** (DB table or object storage). On boot, instances **warm cache**; subscribe to a **file change or DB NOTIFY** channel; expose `/admin/cache/refresh`.
* Keep **secrets** in a vault; forbid putting secrets in per-client JSON served to the browser.

## 3) Database considerations

**Avoid early bottlenecks**

* Start with **primary + read replica(s)**; API reads prefer replicas; writes go to primary.
* **Tenant data model choices**:

  * **Shared DB, tenant\_id column** (fast to start; requires strict row-level scoping).
  * **Schema per tenant** (clean isolation; manual migrations heavier).
  * **DB per tenant** (strong isolation; operationally expensive manually).
* **Sharding path** (when needed): shard by tenant hash or by region; keep a **routing map** the API consults.

**Manual replication/sharding steps**

* Promote read replicas regionally for read-heavy endpoints.
* If splitting, migrate tenants batch-wise: **lock tenant**, copy data, verify checksums, flip routing, unlock.
* **Consistency**: require **idempotent writes**, use **created\_at/updated\_at + version** (optimistic concurrency), and avoid cross-tenant transactions.

---

# Part 3 — Scaling further (500 clients, multi-region)

## 1) Frontend multi-region + CDN

**Regional deploy**

* Stand up **identical frontend servers** in US/EU/APAC.
* DNS: use **Geo-DNS** or anycast LB to direct `*.yourdomain.com` to nearest region. Keep a **region override** for special SLAs.

**CDN**

* Put a **CDN in front** of static assets (hash-named artifacts). Origins = regional frontend buckets/servers.
* Invalidate CDN on release (immutable assets need no purge; only `/index.html` and `/config/*.json` require purge).
* Edge cases: **country-specific legal banners**; vary `/config` by **client + region**; ensure CDN honors **Cache-Key** (include path, not cookies).

## 2) Backend multi-region + regional DBs

**Regional APIs**

* Deploy API clusters in each region; DNS/LB routes clients to **nearest healthy** region by default.
* Keep a **routing policy table**: some clients may be **pinned** to a region for data residency (GDPR) or SLA.

**Cross-region traffic**

* Default: **serve in-region only**; fail over to next closest **read-only** or **degraded mode** if the regional DB is down (document behavior in SLA).
* Specific cross-region routes only when:

  * Third-party integration is region-locked.
  * The client is globally distributed and opted-in to multi-region active-active (higher complexity).

**DB consistency across regions**

* Options:

  * **Single write region, multi read replicas** (simpler, eventual consistency acceptable for reads).
  * **Active–Passive per client** (clients pinned to a primary region; warm standby in another).
  * **Active–Active** with conflict resolution (manual ops nightmare; avoid unless you adopt proper tooling).
* Manual replication playbook:

  1. For each tenant, define **authoritative region**.
  2. Enable **async replication** to DR region.
  3. Document **RTO/RPO**; run **failover drills** quarterly.
  4. Keep **global IDs** (ULIDs) to avoid collisions post-failover; reconcile with **last-write-wins + audit logs**.

---

# Part 4 — Client-specific configurations at scale

## Managing & deploying configurations

* Create a **central config repo** (git) with:

  * `/tenants/{tenantId}/config.json` (features, API base, region pin, SLA)
  * `/tenants/{tenantId}/theme.json` (branding)
  * `/tenants/{tenantId}/integrations/*.json` (OAuth, webhooks—**no secrets**)
* A **config compiler** script generates:

  * **Public runtime bundles** for the frontend (`/config/{tenant}.json`)
  * **Private server bundles** for the API cache
* Manual rollout:

  1. PR reviewed → merge.
  2. Run “publish-configs” script to push public JSON to origin/CDN and notify backend to refresh cache.
  3. **Targeted canary**: flip one tenant to new config via header/cookie flag and verify.

**Branding/logos/endpoints**

* Store logos in object storage under `/branding/{tenant}/…`; reference by URL in `theme.json`.
* Validate image sizes and formats in CI-like script (even in manual world).
* For custom endpoints, guard with **allowlists** per tenant to avoid SSRF or misrouting.

## Challenges & safeguards

* **Config drift**: different regions serving different config versions. → Include **`configVersion`** in JSON; surface it in a support header and UI footer.
* **Mass update risk**: breaking 500 clients. → Batch by **cohorts** (e.g., 25 tenants), and **diff** the compiled output before publish.
* **Testing matrix explosion**: use **feature flags** to limit permutations and a **golden set of tenants** for deep smoke tests.

---

# Real-life manual-ops challenges & how to cope

## 1) Inconsistent environments

* Keep **OS/base image** versions aligned; document exact **Node/PM2** versions.
* Maintain **`.env.example`** for each env; store real values in an encrypted store (not in git).
* Run **environment drift checks** weekly (script that prints versions, open ports, TLS ciphers).
* Risk: “works in staging, breaks in prod” due to missing env vars, different Node versions, or missing fonts/locale packages.

## 2) Downtime during deployments

* Frontend: blue/green + CDN; ship **immutable assets** first, then swap **`index.html`**.
* Backend: drain connections at LB, **graceful shutdown** (SIGTERM → stop accepting, finish in-flight).
* DB migrations:

  * Prefer **backward-compatible** migrations (expand → deploy → contract).
  * For locking/long migrations, schedule **maintenance windows** per region/tenant; communicate.

## 3) Scaling & load balancing

* Health checks must validate **dependencies** (DB/Redis/third-party) not just “process is up.”
* Avoid **stateful app nodes**; if you must keep state (in-memory caches), set small TTLs and be okay with cold starts.
* Document **capacity units** (req/s per node) from a simple wrk/autocannon test so you can size clusters manually.

## 4) Database & data management

* Nightly **backups** per region + **restore drills** monthly.
* Enable **row-level guards** in the API (`WHERE tenant_id = ?`) and unit tests with **tenant-leak canaries**.
* For reporting, offload to a **read replica** or a separate **warehouse** to protect OLTP.
