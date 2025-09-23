# Day 1 — LinkedIn-(Ultra)-Lite

## Part 1 — Setup + “Hello, {YourName}”

**Goal:** Render a friendly hero section.
**Steps:**

* Create with Vite (React + JavaScript) with the command `npm create vite@latest` 
* Create a folder `src/components/` and `src/pages/`.
  **Hints:** Keep `App` minimal; we’ll route to pages tomorrow.
* Name, tagline, short “About me” paragraph.
* A profile image (placeholder ok).
  **Hints:** Store your basic info in a small object and render it.

**Bonus parts:**

* Add a clickable button that toggles your tagline text.
* Show today’s date dynamically under your name.
* Render a random fun fact each time the page reloads.

---

## Part 2 — JSX exercise

**Goal:** Practice expressions, lists, and conditionals.
**Requirements:**

* Show “Open to work” badge only if a boolean is true.
* Render 3 “headline keywords” (e.g., “React”, “UI”, “Teaching”) from an array.
* Use `map` for lists; conditionals with `&&` or ternary.
* Show a message if the array of keywords is empty.

**Bonus parts:**

* Highlight one keyword in bold or with an emoji if it’s your “favorite.”
* Add a counter showing how many keywords you currently have.

---

### Part 3 - Components, Loops & Conditional Rendering

**Goal:** Break UI into logical components.
**Steps:**

* Identify components you’ll need today: `Hero`, `SkillTag`, `SkillList`, `ContactCard`.
* Decide props each component needs (name, title, skills\[]).
  **Hints:** One file per component; prefer small, focused components.
* Create the components and render them.

**Bonus parts:**

* Add a `Footer` component with some silly copyright text.
* Pass an avatar URL into `Hero` as a prop instead of hardcoding.
* Create a reusable `Badge` component that you can use for skills and other labels.

---

## Part 4 - Props and more

**Goal:** Build `SkillList` and `SkillTag`.
**Must-haves:**

* `SkillList` receives `skills` prop (array of strings).
* Renders `SkillTag` for each skill.
* Empty state: show “No skills yet.”
  **Hints:** Keep `SkillTag` simple (just a styled label). Ensure each list item has a key.

**Bonus parts:**

* Add a prop to `SkillTag` that highlights certain skills (e.g., “React” shows with ⭐).
* Render the skills in alphabetical order before mapping.
* Display the total number of skills next to the heading.

---

## Part 5 - Another Exercise (Edit & Delete skills)

**Goal:** Add a new skill via a controlled form.
**Steps:**

* `AddSkillForm` with input + “Add” button (disabled when empty).
* On submit: push into `skills` state and clear the input.
* Prevent duplicates (ignore or show a tiny warning).
  **Hints:** Lift `skills` state to parent so `SkillList` and `AddSkillForm` share it.


**Bonus ideas:**
* Toggle “Open to work”, toggle “dark mode” boolean (no styling yet).
* Each `SkillTag` has a small “x” to delete.
* Add a simple “Edit mode”: click to turn a tag into an input, save/cancel.
* Show “Total skills: X”.
  **Stretch:** Persist skills to `localStorage`.
  **Hints:** For edit mode, store `editingId` or inline state per skill.

**Extra bonus parts:**

* Add a dropdown to categorize skills (e.g., “Frontend”, “Backend”) and display them grouped.
* Let the user reorder skills (move up/down buttons).
* Add a silly “Skill Level” randomizer (Beginner/Intermediate/Expert) that shows on each tag.

