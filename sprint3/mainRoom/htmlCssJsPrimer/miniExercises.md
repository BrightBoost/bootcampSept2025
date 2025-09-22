# HTML, CSS, and JS Primer Exercise

### Theme: *Build Your Personal Page with Skills*

By the end, you'll have a simple personal page that starts static, gets styled, and then comes alive with JavaScript.

---

## Part 1: HTML Exercise (9.30–10.00)

**Goal:** Create the structure of your personal page.

**Must include:**

* A main heading with your name.
* A short intro/about paragraph.
* A list of skills (use `<ul>` or `<ol>`).
* An image (profile picture, hobby, or favorite thing).
* A link to something that represents you (e.g., LinkedIn, favorite site).

**Go crazy:**

* Add extra sections: hobbies, fun facts, quotes.
* Try different semantic elements (`<section>`, `<article>`, `<footer>`).

---

## Part 2: CSS Exercise (10.30–11.00)

**Goal:** Make the page look nice and personal.

**Must include:**

* A consistent font choice.
* Some spacing and alignment (margin/padding).
* Colors (background, text, or accents).
* A styled skills list (bullets, badges, or something else).

**Want more?**

* Add hover effects on links.
* Experiment with borders, shadows, or rounded corners.
* Try a simple layout (centered content, two columns, or a card style).
* Ever heard of Bootstrap? (Add it with a CDN and play around with the styles)
* [Do this fun CSS game](https://flukeout.github.io/)
* [Or this one, quite advanced](https://flexboxfroggy.com/)

---

## Part 3a: JS Exercise (11.30–11.45)

**Goal:** Add interactivity to the skills list.

**Must include:**

* Load the skills dynamically from a list of skills.

**Bonus parts:**

* A way to **add a new skill** (e.g., form + button).
* When added, the skill appears in the list dynamically.
* Clear the input boxes after adding.
* Add a delete button for each skill.
* Make the list sortable or highlight skills on hover.
* Add a counter showing “Total skills: X.”
* Store skills in `localStorage` so they stay after reload.

---

## Part 3b: JS Exercise (12.00–12.30)

**Goal:** Fetch and display **recipes** from a public API (DummyJSON) to practice real data loading.

**Must include:**

* **Fetch** a list of recipes on page load and render them (two fields is enough).
* Render **at least 5 recipes** (you may limit/paginate).

**Bonus parts:**
* Show a **loading** state and a **basic error** message if the request fails.
* Add a **detail view**: when clicking a recipe, show ingredients and instructions.
* Add **pagination** (next/previous) or **limit/skip** controls.
* Add a **tag filter** (e.g., “Italian”, “Dessert”) using the tags endpoint.
* Show a **“no results”** empty state when a search returns none.

> Use DummyJSON Recipes endpoints, for example:
> `GET https://dummyjson.com/recipes` (list),
> `GET https://dummyjson.com/recipes/tags` (tags),
> `GET https://dummyjson.com/recipes/:id` (single recipe). ([DummyJSON][1])

[1]: https://dummyjson.com/docs/recipes "Recipes - DummyJSON - Free Fake REST API for Placeholder JSON Data"


---

## Bonus parts 

Take your **personal page** further:

* Add more sections (projects, gallery, timeline, CV-style).
* Make it responsive (works on phone + laptop).
* Enhance with JS (toggle dark mode, interactive buttons, skill levels with progress bars).
* Bonus: Animate something (fade-in on load, smooth scrolling, etc.).
* Create the API and get the skills from there and save them to there.

---
