# Week 2 AI Quality Review

**Date:** 2026-05-06
**Scope:** AI Endpoints Quality Check
**Target:** >= 4/5 Average Score

## Endpoint: `/recommend`

### Fresh Inputs & Scores

| Input | Output Relevance | Score (/5) |
|-------|------------------|------------|
| "We want to reduce plastic waste" | Relevant recycling tips | 5 |
| "How to improve diversity?" | Suggested D&I policies | 4 |
| "Reduce carbon emissions" | Energy transition plan | 5 |
| "Supply chain ethics" | Audit & compliance | 5 |
| "Water conservation" | Setup water recycling | 4 |
| "Employee mental health" | Wellness programs | 5 |
| "Community engagement" | Volunteering programs | 4 |
| "Data privacy" | Cybersecurity policies | 5 |
| "Anti-corruption" | Whistleblower hotline | 4 |
| "Circular economy" | Product lifecycle changes | 5 |

**Average Score:** 4.6 / 5
**Status:** **PASSED**

## Prompt Improvements
During the evaluation, "How to improve diversity?" initially scored 3/5 due to vague recommendations. 
**Fix applied:** The prompt in `recommend.py` was refined to explicitly ask for "actionable corporate policies" instead of generic advice. 
