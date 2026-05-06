# AI Service Summary Card
**Project:** ESG Reporting Engine

## 💻 Tech Stack
- **Framework:** Flask (Python 3.10)
- **AI Provider:** Groq API (LLaMA-3 / Mixtral)
- **Security:** Flask-Limiter, Flask-Talisman, JWT Authentication
- **Containerization:** Docker & Docker-Compose

## 🔗 Repository
[GitHub - Manasiku/esg-reporting-engine](https://github.com/Manasiku/esg-reporting-engine)

## 🌐 Endpoints
1. `POST /recommend`
   - **Purpose:** Generates structured ESG policies.
   - **Input:** `{"text": "corporate goal"}`
   - **Security:** Requires JWT, Rate-limited.
2. `GET /health`
   - **Purpose:** Service uptime verification.
3. `POST /describe`
   - **Purpose:** Analyzes general ESG text.
