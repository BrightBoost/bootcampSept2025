# Day 2 — LinkedIn-(Ultra)-Lite

--

## Part 6 — GET: Fetch & List Users

**Goal:** Fetch people and render a mini “profiles” list.

**Must-haves:**

* In `Users.jsx`, fetch data from **DummyJSON**:

  * `GET https://dummyjson.com/users` (returns `{ users: [...] }`)
* Show a loading state (“Loading…”) and an error state if the fetch fails.
* Render each user as a small card: name + username + email.
* Each card has a “View details” link/button.

**Bonus parts:**

* Add a tiny search/filter box (client-side) to filter by name.
* Sort users alphabetically by last name with a toggle.
* Show an avatar using `user.image` (DummyJSON provides one).
* Paginate client-side (e.g., 10 per page) with “Prev/Next.”

---

## Part 7 — POST & PUT: Playground (No visible persistence…)

**Goal:** Try sending data with POST and PUT to see request/response shape.

**Must-haves:**

* Create a simple “Playground” section on the `UserDetails` page (or a new `Playground.jsx` route).
* Add a minimal form with two fields (e.g., `firstName`, `lastName`).
* On submit, `POST https://dummyjson.com/users/add`

  * Show the **response JSON** below the form (pretty-printed).
* Bonus: Add a “Update name” button that does:

  * Bonus part: `PUT https://dummyjson.com/users/1` with a body like `{ firstName: 'New' }`
  * Show the **response JSON** below the button.

**Important explainer:**

* DummyJSON **echoes** your POST/PUT and **doesn’t persist** changes.
* You **won’t** see the difference when you re-fetch the users list right now.
* **Reassure:** In the afternoon, with your own mini API, you’ll see real changes.

**Bonus parts:**

* Disable the submit button while the request is in flight.
* Validate fields (e.g., require min length) and show a tiny inline error.
* Add a “Reset” button that clears the form and response.
* Add a radio toggle to switch between `PUT` vs `PATCH` and compare responses.

---
## Part 8 — Basic Routing

**Goal:** Navigate between pages.

**Steps:**

* Install router: `npm i react-router-dom`
* Create `src/pages/Home.jsx`, `src/pages/Contact.jsx`, and `src/pages/Users.jsx`.
* In `main.jsx`, wrap `<App />` with `<BrowserRouter>`.
* In `App.jsx`, add routes:

  * `/` to `Home`
  * `/contact` to `Contact`
  * `/users` to `Users`
* Add a simple nav with links (Home | Users | Contact).

**Bonus parts:**

* Style the active link (underline or bold).
* Add a “Back” button to `Contact` that uses `useNavigate(-1)`.
* Extract a `<Navbar />` component and reuse it.

-

## Part 9 — Route Params: User Details

**Goal:** Click a user → navigate to `/users/:id` → fetch details by ID.

**Must-haves:**

* Create `src/pages/UserDetails.jsx`.
* Add a route: `/users/:id`.
* In `Users.jsx`, “View details” should link to `/users/{id}`.
* In `UserDetails.jsx`, read the `id` from `useParams()` and fetch:

  * `GET https://dummyjson.com/users/:id`
* Render key fields (name, age, email, phone, company, address).

**Bonus parts:**

* Show a skeleton UI while loading (gray boxes).
* If an invalid ID is opened, show a friendly “User not found.”
* Add tabs (Profile | Company | Address) with conditional rendering.

---



