import os
import requests
import json
from dotenv import load_dotenv

load_dotenv()

API_KEY = os.getenv("GROQ_API_KEY")


def call_groq(prompt):
    url = "https://api.groq.com/openai/v1/chat/completions"

    headers = {
        "Authorization": f"Bearer {API_KEY}",
        "Content-Type": "application/json"
    }

    data = {
        "model": "llama-3.3-70b-versatile",
        "messages": [
            {"role": "user", "content": prompt}
        ],
        "temperature": 0.3
    }

    response = requests.post(url, json=data, headers=headers)

    # Debug print
    print("RAW RESPONSE:", response.text)

    result = response.json()


    if "choices" in result:
        content = result["choices"][0]["message"]["content"]

        try:
            parsed = json.loads(content)
            if isinstance(parsed, dict):
                return {
                    "summary": parsed.get("summary", ""),
                    "key_issues": parsed.get("key_issues", []),
                    "business_impact": parsed.get("business_impact", "")
                }
            else:
                return parsed
        except:
            # fallback (convert text → structured)
            return {
            "summary": content,
            "key_issues": [],
            "business_impact": ""
        }
    else:
        return {
            "error": result
        }
    
    