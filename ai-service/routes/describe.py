from flask import Blueprint, request, jsonify
from services.groq_client import generate_response
from datetime import datetime

describe_bp = Blueprint("describe", __name__)

@describe_bp.route("/describe", methods=["POST"])
def describe():
    try:
        data = request.get_json()

        if not data or "text" not in data:
            return jsonify({"error": "Missing 'text' field"}), 400

        user_input = data["text"]

        # Strip HTML (basic)
        user_input = user_input.replace("<", "").replace(">", "")

        # Detect prompt injection
        blocked = [
            "ignore previous instructions",
            "give api key",
            "reveal secret",
            "bypass",
            "system prompt"
        ]

        for word in blocked:
            if word in user_input.lower():
                return jsonify({"error": "Invalid input detected"}), 400

        ai_output = generate_response(user_input)

        return jsonify({
            "input": user_input,
            "output": ai_output,
            "generated_at": datetime.now().isoformat()
        })

    except Exception as e:
        return jsonify({"error": str(e)}), 500