# Setup SSH with Bitbucket and Push Code


##  Step 1: Generate SSH Key

Open **Terminal / Git Bash** and run:

```bash
ssh-keygen -t rsa -b 4096 -C "your_email@example.com"
```

- Press **Enter** to accept the default file location.  
- Enter a passphrase (**optional but recommended**).  
- Enter your passphrase which you need to rememebr when you push code using SSH

This generates two files:
- **Private key** → `~/.ssh/id_rsa`
- **Public key** → `~/.ssh/id_rsa.pub`

---

##  Step 2: Add SSH Key to SSH Agent

Start the SSH agent: 

```bash
eval "$(ssh-agent -s)"
```

Add your private key: Here it will ask you to enter your passphrase

```bash
ssh-add ~/.ssh/id_rsa
```

---

##  Step 3: Add SSH Key to Bitbucket

1. Copy your public key:
   ```bash
   cat ~/.ssh/id_rsa.pub
   ```
2. Log in to **Bitbucket**.  
3. Go to **Personal settings → SSH keys → Add key**.  
4. Paste the copied key and give it a label (e.g., `MyLaptop`).  

---

##  Step 4: Test SSH Connection

Run:

```bash
ssh -T git@bitbucket.org
```

Expected output:

```
authenticated via ssh key.
You can use git to connect to Bitbucket.
```

---

##  Step 5: Connect Your Repository

If you already have a local repo, set the remote to SSH:

```bash
git remote set-url origin git@bitbucket.org:username/reponame.git
```

Or clone a new repo using SSH:

```bash
git clone git@bitbucket.org:username/reponame.git
```

---

##  Step 6: Push Code

Inside your repository folder, run:

```bash
git add .
git commit -m "Initial commit"
git push origin main
```

**Now your code is securely pushed to Bitbucket using SSH!**
