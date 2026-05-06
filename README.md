# ESG Reporting Engine

## How to Execute the Project Locally (Demo Setup)

To show the demo on your system with a fresh state, you will need to run the application using Docker Compose.

### Step 1: Ensure Prerequisites
Make sure you have [Docker Desktop](https://www.docker.com/products/docker-desktop/) installed and running on your system.

### Step 2: Fresh Seeded State (Day 17 Task)
If you have run the project before and want a clean slate for the demo, run the following in your terminal:
```bash
docker-compose down -v
```

### Step 3: Start the Application
To spin up the entire application (Frontend, Backend, and AI Service), run:
```bash
docker-compose up --build
```
*Wait for all the services to fully start.*

### Step 4: Access the Services
- **Frontend UI:** Open your browser to `http://localhost:5173`
- **Backend API:** Runs on `http://localhost:8080`
- **AI Service Health Check:** Open `http://localhost:5000/health` to confirm it is running.

### Demo Flow
1. **Explain the Tech Stack (Day 20):** Mention React (Frontend), Java Spring Boot (Backend), and Python Flask (AI Service).
2. **AI Recommend:** Enter a goal in the UI to see Groq AI generate ESG recommendations.
3. **Security Demo:** Try to type "Ignore previous instructions" in the UI; the AI service will return an error, proving our Prompt Injection defense works.
4. **References:** Refer to `backend/SECURITY.md` for the final executive sign-off!