# Day 2 — Cozy Shelter **API + Routing**

Today you’ll:

1. Spin up a **Spring Boot REST API** with **MySQL**.
2. Call it from your **React** app (fetch GET/POST/PUT/DELETE).
3. Add **routing**: list page → details page (by `:id`) → contact page.

> Continue to work on the same “shelter” you used yesterday (animals / unicorns / socks / ducks / houseplants, etc.).
> We’ll call the entity **Resident** in the code. Rename it to fit your theme if you want.

---

## Part A — Spring Boot API 

### Create project

* Use **Spring Initializr** (or your IDE wizard).
* **Dependencies**: *Spring Web*, *Spring Data JPA*, *MySQL Database*.
* **Group/Artifact**: anything you like (e.g., `com.cozy.shelter` / `cozy-shelter`).
* Run the app once to check it starts.
* Create the correct config for `application.properties`.


### Entity + Repository

### REST Controller

You can annotate it with `@CrossOrigin` to not get CORS errors. Or do it the proper way and set up correct CORS config. (I recommend option 1 because it's ambitious enough for the afternoon as is.)


## Part B — React: Call Your API + Routing (30–45 min)

> Use your Vite React project from yesterday.

### Install router (if you don’t have it yet)

```bash
npm i react-router-dom
```

### Wrap the app (`main.jsx`)

```jsx
  <React.StrictMode>
    <BrowserRouter>
      <App />
    </BrowserRouter>
  </React.StrictMode>

```

### Define routes + nav (`App.jsx`)

### Pages (minimal versions)

- `src/pages/Home.jsx`
- `src/pages/Contact.jsx`


### List + Create residents (GET + POST)

- `src/pages/Residents.jsx`

### Details page (GET by `:id`) + simple update (PUT) and delete

- `src/pages/ResidentDetails.jsx`

---

## What to verify (quick checks)

* Visiting **/residents** shows the seeded list from your **own API**.
* Adding via the form **POSTs** to your API and **refetches** the list.
* Details page fetches by `:id`.
* Toggle availability **PUTs** and refreshes.
* Delete works and navigates back to the list.
* Contact page is reachable from the nav.

---

## Bonus (or come up with your own)

* Add **filter** `?available=true` query param in the client (do client-side filter) or add a real finder method later.
* Add field validation on the backend (e.g., reject empty `name`) with a friendly error in the UI.
* Add a **PATCH** endpoint for partial updates.
* Style active links with `NavLink`.

