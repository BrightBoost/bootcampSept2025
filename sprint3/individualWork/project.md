# Advanced Frontend Mini-Project

## Why this project?

You already know the concepts (components, hooks, state, forms, API calls). At this stage, you’ll learn more by **building a small product** than by doing isolated exercises. You’ll learn more from building a usable MVP than from listening to this MvP. 😉

## Project planning (this happens before you code!)

Professional developers shouldn't just dive into the editor but they a plan first. For this project, you must start by creating a project board (Jira, Trello, GitHub Projects, Notion, sticky notes on your white board — whatever you like). Break it down into smaller tasks and put them in order. Identify any dependencies between tasks, especially if you're doing this with more than 1 person.

## Must-have requirements (for any option)

- **Routing** with at least 2–3 pages (e.g., `/`, `/detail/:id`, `/create`).
- **Data fetching** with **GET** and **POST** to your Spring Boot API (you may also use PUT/DELETE).
- **Dynamic UI**: lists render from server data; detail pages fetch by id; loading & error states.
- **Forms** with validation and server persistence (POST/PUT).
- **State management**: Local state (e.g. `useState` or own hook) and server state (data from your API)
- **Accessibility basics**: focus management on route change, form labels, keyboard-reachable controls.
- **Docs**: a (pretty) README with setup steps, sample `.http`/cURL requests, and API description.

> You may work solo or in pairs. You can adapt the scope and topic, just keep the must-haves.
> Are you a React expert already? Why not try a different framework, how about Angular? Or Vue? Or Svelte?

---

# Choose your own topioc or pick ONE project

## 1) Shared Playlist / Party DJ 🎶

**Pitch:** Friends add songs and upvote the queue. Highest votes play next.

**Key screens**

- Queue (list of songs + vote buttons)
- Add Song (URL + title)
- Now Playing (shows current track, skip if > X downvotes)

**Example API**

- `GET /songs` → `[{id,title,url,votes}]`
- `POST /songs` → `{title,url}`
- `POST /votes` → `{songId, delta: +1|-1}`
- `GET /now-playing` → `{songId, startedAt}`
- _(Optional)_ WebSocket/SSE `/events` to broadcast votes/now-playing

**Stretch**

- Optimistic voting + rollback on failure
- Moderation (block duplicates), skip rule (e.g., −5 total votes)

---

## 2) Group Dinner Picker 🍜

**Pitch:** Propose places, vote, lock the winner at a deadline.

**Key screens**

- Proposals list (with live rank changes)
- Add proposal (name + link)
- Results (winner + RSVP)

**Example API**

- `GET /options` → `[{id,name,link,votes}]`
- `POST /options` → `{name,link}`
- `POST /vote` → `{optionId, delta}`
- `POST /lock` → `{locked:true}` (teacher account or rule-based)

**Stretch**

- Location autocomplete (client-side)
- “Dietary tags” filter (vegan/halal/etc.)

---

## 3) Gym Buddy Tracker 🏋️

**Pitch:** Log workouts, see weekly progress, compare with gym buddies.

**Key screens**

- Workouts list (filter by week)
- Add workout (exercise, sets, reps, weight, RPE)
- Progress (simple chart: volume per week)

**Example API**

- `GET /workouts?week=YYYY-WW` → workout entries
- `POST /workouts` → `{date,exercise,sets,reps,weight,rpe}`
- `GET /stats?range=last4w` → `{week,volume}[]`

**Stretch**

- Streaks (“X days active”)
- Share code to follow a friend’s stats

---

## 4) Event Night Planner 🎉

**Pitch:** Create an event, invite friends, track RSVPs & comments.

**Key screens**

- Events list
- Event detail (date/time, location, attendees, comments)
- Create event

**Example API**

- `GET /events` → `[{id,title,date,location}]`
- `GET /events/:id` → event + `attendees[]`, `comments[]`
- `POST /events` → `{title,date,location,desc}`
- `POST /rsvp` → `{eventId, status: going|maybe|no}`
- `POST /comments` → `{eventId, text}`

**Stretch**

- iCal export link (server returns .ics)
- Simple mentions `@name` in comments

---

## 5) Meme Caption Battle 🖼️

**Pitch:** Upload a meme/template, everyone submits captions, vote the winner.

**Key screens**

- Gallery (templates)
- Template detail (captions + votes)
- Upload template

**Example API**

- `GET /templates` → `[{id,imageUrl}]`
- `POST /templates` → `{imageUrl | file}`
- `POST /captions` → `{templateId, text}`
- `POST /votes` → `{captionId, delta}`

**Stretch**

- Round timer; leaderboard across rounds
- Image moderation (client-side URL validation)

---

# Tech guidance (suggested)

**Frontend**

- React + React Router
- Your own components or a basic component lib
- Optional: go wild, charting (Progress page) with a minimal lib or `<canvas>`

**Backend (Spring Boot)**

- Entities that match your chosen app
- Controllers for the endpoints above (use `@CrossOrigin` to avoid CORS errors)
- In-memory storage is OK for speed; bonus for JPA/H2
- Return proper status codes + validation errors (400, 404, etc.)

---

# Requirements checklist 

- [ ] At least 3 routes (list, detail, create/edit).
- [ ] Uses **GET** and **POST** (and optionally PUT/DELETE).
- [ ] List page renders data from the API, with loading & error states.
- [ ] Form posts data and shows success/failure feedback.
- [ ] Detail page fetches by id.
- [ ] Accessible labels on form inputs; keyboard reachable actions.
- [ ] Clear README with run steps for both apps and a brief API spec.
- [ ] At least 5 meaningful commits with messages that describe intent.
