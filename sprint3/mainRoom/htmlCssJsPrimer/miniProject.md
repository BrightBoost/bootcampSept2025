# Project time

Here’s your afternoon mini-project with **3 paths**. Pick one (or mix & match), ship something you’re proud of, and keep it classy on API choices 🙏 (⚠️ heads-up: a lot of “jokes” APIs contain content that’s not appropriate or inclusive—please avoid those.)

---

# 🎯 Your Mission

Build a small web app (HTML, CSS, JS) that **fetches data** and **displays it nicely**. You’ll have:

* A **list or grid view or detail** of items.
* If you have a list, you'll also have a **details** view.
* **Good UX**: loading state, error state, empty state.

Show us are at the end. You’ve got this. 💪

---

# Option A — Choose an API (e.g., PokeAPI)

**Goal:** Pick any open and SFW API and build a mini UI on top.

**Examples (safe picks):**

* **PokeAPI**: list Pokémon, show details (types, abilities, sprites).
* **Studio Ghibli API**: films list, details page in a modal.
* **SpaceX data**: launches list, show rocket details.

**Requirements:**

1. Fetch a list endpoint; render responsive cards (image + title + short description).
2. Click a card ➜ show details (in modal or dedicated section).
3. Handle **loading**, **errors**, and **no results** with friendly UI.

**Nice-to-haves:**
* Include a **search box** (by name/title).
* Pagination (“Load more”).
* Client-side **favorites** (localStorage).
* Filter chips (type, year, etc.).

> ⚠️ Avoid “joke” or “edgy” content APIs. They often include stereotypes or NSFW content. You know, it's not hard to write your own Joke API, and that brings us to option B. ✨

---

# 🛠️ Option B — Spring Boot + Your Frontend

**Goal:** Spin up a tiny Spring Boot app that exposes one **GET** endpoint, then consume it from your frontend.

**Backend (Java / Spring Boot)**

* Create a simple controller that returns JSON. Example:

```java
@RestController
@RequestMapping("/api/recipes")
@CrossOrigin // quick-and-dirty for dev; prefer a proper CORS config in real apps
public class RecipeController {
    @GetMapping
    public List<Map<String, Object>> list() {
        return List.of(
            Map.of("id", 1, "name", "Pasta Primavera", "description", "Fresh veggies + pasta", "image", "https://picsum.photos/seed/pasta/600/400"),
            Map.of("id", 2, "name", "Berry Smoothie", "description", "Blueberries, banana, oat milk", "image", "https://picsum.photos/seed/smoothie/600/400")
        );
    }
}
```

* Run on `http://localhost:8080`.
* If you don’t want `@CrossOrigin` on the controller, you can add a basic CORS config bean.

**Frontend**

* Display the data from the API

**Nice-to-haves:**

* Add a second endpoint `/api/recipes/{id}` and load details dynamically.
* Add query params for server-side search `?q=...`.

---

# 🧰 Option C — DummyJSON (zero-creativity mode)

If you’re not in a creative mood, pick **DummyJSON** and implement a clean UI.

**Pick one dataset:**

* `https://dummyjson.com/recipes?limit=20`
* `https://dummyjson.com/todos?limit=20`
* `https://dummyjson.com/products?limit=20`
* `https://dummyjson.com/users?limit=20`

**Minimum features (do these):**

1. Render a **grid of cards** with image (if available), title, and a one-line description.
2. A **search** input that filters items (client-side is OK).
3. **Details modal** on click showing the full JSON for that item (starter template already has this!).
4. Show **loading** state while fetching, **error** state if request fails, and **empty** state if no items match.

**Stretch ideas:**

* Sort dropdown (e.g., A–Z, highest rating).
* Filter chips (e.g., recipe cuisine, product category).
* Pagination or infinite scroll.
* “Favorite” items stored in `localStorage`.
* Chef hat icon somewhere because… why not.

---

# ✅ Acceptance Criteria (what it needs)

* **Data loads** and is **rendered nicely** (cards with spacing and readable text).
* **Details view** works (modal or dedicated area).
* **Search** works.
* Clear **loading**, **error**, and **empty** states.
* **Accessibility basics**: semantic HTML where practical, alt text for images (or hide decorative images), keyboard-reachable controls, etc

---

# 🧪 Extra Credit 

* Client-side routing (hash-based) for deep-linking an item.
* Dark/light theme toggle (remember user preference).
* Debounced search that hits the API’s own search endpoint when available.
* Unit-test a small pure function (e.g., your sorting or filtering logic).

---
