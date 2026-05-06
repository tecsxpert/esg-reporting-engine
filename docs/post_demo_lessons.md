# Post-Demo Lessons Learned

**Date:** 2026-05-06
**Event:** Final ESG Reporting Engine Demo

## 1. Feedback & Observations
- **AI Speed:** The Groq API response time was phenomenally fast, taking under ~500ms to generate structured JSON. The non-technical panel was highly impressed by the real-time nature of the recommendations.
- **Security Demonstration:** The live test of typing "Ignore previous instructions" and receiving an immediate 400 Bad Request error successfully proved to the panel that our system is Enterprise-ready and actively mitigates LLM jailbreaking.
- **Docker Integration:** Containerizing the frontend, backend, and Python AI service together proved crucial for ensuring everyone could spin up the app seamlessly during the final week.

## 2. Features for Future Sprints
- **Streaming Output (SSE):** Even though Groq is fast, implementing Server-Sent Events (SSE) so text types out like ChatGPT will improve the UI feel for longer reports.
- **Persistent AI Memory:** Connecting the AI Service to a Vector Database (like Pinecone) or PostgreSQL using `pgvector` to allow the AI to remember the user's company profile across sessions.
- **Granular Rate Limiting:** Enhance Flask-Limiter to dynamically scale rate limits depending on the user's JWT tier.

## 3. Feedback to Mentor
"The structured 20-day plan forced us to think about security (JWT, Talisman, Prompt Injection) alongside AI quality from day one. This holistic approach resulted in a production-ready system rather than just a fragile prototype. Thank you for the guidance on integrating Java with Python seamlessly!"
