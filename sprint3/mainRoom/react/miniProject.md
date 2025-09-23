# Afternoon Mini Project — **Cozy Shelter** (pick a theme)

We'll practice what we've done so far: components, JSX, props, state, forms, events, simple conditionals. No routing, no APIs.

Choose one of the following "shelter" ideas (or something else if you're creative):

* Animal Shelter (cats, dogs, hamsters)
* Unicorn Refuge (sparkle levels vary)
* Abandoned LP Players Home
* Lost Socks Sanctuary
* Retired Rubber Duck Retreat
* Endangered Houseplants Haven

## Requirements (must-haves)

* **Header**: shelter name + tiny tagline (“No sock left behind”).
* **Resident list**: render a list from state (array). Each resident shows:
  * name, type/breed (or category), age/condition, and a fun “mood” (e.g., “crumbly,” “sassy”).
  * an **availability badge**: “Available” or “Adopted”.
* **Intake form** to add a resident:
  * inputs for name and one other field (type/mood/etc.)
  * “Add” button disabled when required fields are empty
  * prevent duplicates by name (show a tiny warning or ignore)
* **Actions on each resident**:
  * **Adopt** (toggle to “Adopted” or remove from list — your choice)
  * **Delete** (remove from list)
  * **Edit** (inline: click name → input → save/cancel)
* **Stats bar**:
  * total residents, available residents, adopted residents
* **Empty state**:
  * if the list is empty, show a friendly message/emoji instead of a blank screen

## Components (suggested)

* `Header` (title + tagline)
* `StatsBar` (counts; gets numbers via props)
* `IntakeForm` (controlled inputs; calls up to add)
* `ResidentList` (receives array; maps to cards)
* `ResidentCard` (displays one resident + buttons; communicates events up)

*(keep state in a parent so `IntakeForm`, `ResidentList`, and `StatsBar` can share it.)*

## Functionality checks

* Adding via the form updates the list without a refresh
* Adopt/delete/edit work and update the counts
* No console errors; list items have stable keys
* Empty state and badges render correctly

## Bonus ideas (pick a few or come up with your own)

* **Filters**: toggle “Show only available”
* **Sort**: by name or by “cuteness”/“sparkle”/“crunchiness”
* **Capacity flag**: when `total >= capacity`, show “Shelter full!” badge
* **Urgency highlight**: mood === “wilted” or age > X → show a subtle ⚠️
* **Bulk actions**: “Adopt all available” or “Clear adopted”
* **Theme toggle**: `light/dark` via a simple boolean (no styling required)
* **Local persistence**: save residents to `localStorage` (stretch)
* **Fun generator**: quick-add button that picks a random silly resident

