# PII Audit Report

**Date:** 2026-05-06
**Scope:** AI Service Prompts and Groq API communication

## Objective
Verify that no Personally Identifiable Information (PII) is transmitted to the Groq API during request handling.

## Findings
1. **Input Payload Inspection:** The only input taken from users in `/recommend` is the `text` field, which contains corporate sustainability goals or descriptions. 
2. **Backend Masking:** The Java backend currently strips user session identifiers before sending requests to the AI Service.
3. **Prompt Contents:** Prompts consist purely of ESG definitions and structural formatting commands. No user names, email addresses, or specific financial identifiers are injected.

## Conclusion
The system successfully isolates and protects PII. **Status: PASSED**
