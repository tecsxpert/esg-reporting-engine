import os
import requests
import time
from dotenv import load_dotenv

# Load environment variables
load_dotenv()

# Get API key
API_KEY = os.getenv("GROQ_API_KEY")

# API URL
URL = "https://api.groq.com/openai/v1/chat/completions"

# Headers
HEADERS = {
    "Authorization": f"Bearer {API_KEY}",
    "Content-Type": "application/json"
}

def generate_response(prompt, retries=3):
    data = {
        "model": "llama-3.3-70b-versatile",
        "messages": [
            {"role": "user", "content": prompt}
        ]
    }

    for attempt in range(retries):
        try:
            response = requests.post(URL, headers=HEADERS, json=data, timeout=10)

            # Success
            if response.status_code == 200:
                result = response.json()
                return result["choices"][0]["message"]["content"]

            # Error response
            else:
                print(f"Attempt {attempt+1} failed with status {response.status_code}")
                print(response.text)

        except Exception as e:
            print(f"Attempt {attempt+1} exception: {e}")

        # wait before retry
        time.sleep(2)

    # Fallback response (VERY IMPORTANT)
    return "AI service is currently unavailable. Please try again later."