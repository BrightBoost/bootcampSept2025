# Day 2½ — Cozy Shelter **Testing (Vitest + React Testing Library)**

## What you’ll do

1. Add a **unit/UI test setup** to your existing Vite + React app.
2. Write a few **behavioral tests** for your Residents list, the details page, and routing.
3. Mock network calls so tests are **fast and deterministic**.

> We test **what the user sees and does** (not internals): loading → success → error, clicking buttons/links, and simple navigation.

---

## Setup (follow the docs, not a step list)

Use the official docs to add testing to your Vite project for your system:

* **Vitest**: configuration, `jsdom` environment, scripts
* **React Testing Library**: rendering + queries
* **@testing-library/jest-dom**: helpful matchers
* **@testing-library/user-event**: realistic user interactions

> Docs to consult: **Vitest “Getting Started” & “Config”**, **Testing Library React docs**, **jest-dom** readme, and **user-event** docs.
> Ensure your Vitest config uses the **`jsdom`** environment and a **test setup file** where you import `@testing-library/jest-dom`.

### Your acceptance criteria for setup

* You can run `npm test` (or `vitest`) and see the runner load.
* `render(<div />)` works in a test file without browser errors.
* `expect(element).toBeInTheDocument()` compiles (from `jest-dom`).
* Tests can import your components with normal paths (e.g., `src/pages/Residents.jsx`).

---

## Ideas for what to test

Write at least **2 passing tests**, you could cover:

1. **Residents list loads** (happy path): after clicking your “Load/Refresh” button (or on mount), fetched residents appear.
2. **Loading state**: while the request is in flight, show a loading indicator / disabled button.
3. **Error state**: backend returns `500` (or network error) → show a friendly error.
4. **Details navigation**: clicking a resident’s “Details” link navigates to `/residents/:id` and shows that resident’s info.

> If you have create/update/delete in your UI, you could add:

5. **Create**: submitting the add form calls the POST endpoint and then shows the new entry (either via refetch or optimistic update).

---
