# OWASP Juice Shop Challenge Walkthroughs

This guide provides step-by-step hints and solutions for selected OWASP Juice Shop challenges.  
Follow along carefully, and try to understand *why* each step works — not just how to do it.

---

## Bully Chatbot

- Just keep asking the chatbot for a coupon code.  
- After 3 requests, it should give you one!

---

## Access a Confidential Document

1. Click on **About Us** in the menu.  
2. Click the link to **"Check out our boring terms of use"**.  
3. Notice the URL is: http://localhost:3000/ftp/legal.md

4. What happens if we try: http://localhost:3000/ftp

→ We see directory contents!

5. Now try: http://localhost:3000/ftp/acquisitions.md

→ This reveals confidential content.

---

## Admin Login

Can we find the **admin user’s email address**?

1. Open **Developer Tools** → **Sources** tab.  
2. Open `main.js` and search for an email (tip: search for `@jui`).  
- You’ll find: `testing@juice-sh.op`.  
3. From this, we can guess the admin user is:  admin@juice-sh.op

4. Validate the email:
- Go to the **Reset Password** page.  
- Enter the guessed email.  
- The **security question** only appears if the email exists → confirmation!

5. Now let’s try an **SQL injection**:  
- Hypothetical backend query:

  ```sql
  SELECT * FROM users WHERE email = '$email' AND password = '$password';
  ```

- By entering:

  ```
  admin@juice-sh.op'--
  ```

  the query becomes:

  ```sql
  SELECT * FROM users WHERE email = 'admin@juice-sh.op'-- ' AND password = 'whatever';
  ```

  → The password check is commented out!

6. Log in with:
- Username: admin@juice-sh.op'--
- Password: anything


---

## Access the Administration Section

1. Open **Developer Tools** → **Sources** → `main.js`.  
2. Search for `"admin"`.  
3. You’ll find the path:administration

4. Guess the URL:http://localhost:3000/#/administration
- If you’re not logged in as admin → **403 Forbidden**.  
- If you’re already logged in (see previous challenge) →  access granted!

---






