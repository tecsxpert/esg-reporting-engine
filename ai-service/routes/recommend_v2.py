from flask import Blueprint, request, jsonify
from datetime import datetime
from services.groq_client import call_groq
import json
import os

recommend_bp = Blueprint("recommend", __name__)

@recommend_bp.route("/recommend", methods=["POST"])
def recommend():
    data = request.get_json()

    if not data or "text" not in data:
        return jsonify({"error": "Missing 'text' field"}), 400

    user_input = data["text"]

    BASE_DIR = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
    prompt_path = os.path.join(BASE_DIR, "prompts", "recommend.txt")

    with open(prompt_path, "r") as f:
        prompt_template = f.read()

    final_prompt = prompt_template + "\n" + user_input

    ai_response = call_groq(final_prompt)

    if isinstance(ai_response, dict):
        ai_json = ai_response
    else:
        try:
            start = ai_response.find("{")
            end = ai_response.rfind("}") + 1
            ai_json = json.loads(ai_response[start:end])
        except Exception:
            return jsonify({
                "error": "AI response is not valid JSON",
                "raw_output": ai_response
            }), 500

    return jsonify({
        "recommendations": ai_json.get("recommendations", []),
        "generated_at": datetime.utcnow().isoformat()
    })