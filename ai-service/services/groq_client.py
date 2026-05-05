import os
import requests
import json
import re
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
            match = re.search(r'\{.*\}', content, re.DOTALL)
            if match:
                json_str = match.group()
            else:
                json_str = content
            
            parsed = json.loads(json_str)
            return parsed
        except:
            return content
    else:
        return {
            "error": result
        }
    