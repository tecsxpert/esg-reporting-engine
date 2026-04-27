from flask import Blueprint, request, jsonify
from services.groq_client import call_groq
from datetime import datetime

describe_bp = Blueprint("describe", __name__)

#loading prompt
def load_prompt(user_input):
    with open("prompts/describe.txt") as f:
        base_prompt = f.read()
    return base_prompt + user_input


@describe_bp.route("/describe", methods=["POST"])
def describe():
    data = request.get_json()

    #validation!
    if not data or "text" not in data:
        return jsonify({"error": "Missing 'text' field"}), 400

    user_input = data["text"]

    if len(user_input.strip()) == 0:
        return jsonify({"error": "Empty input"}), 400

    #prompt
    prompt = load_prompt(user_input)

    #AI call
    ai_response = call_groq(prompt)

    #response
    if isinstance(ai_response, dict):
        return jsonify({
        **ai_response,
        "generated_at": datetime.utcnow().isoformat()
    })
    else:
        return jsonify({
            "result": ai_response,
            "generated_at": datetime.utcnow().isoformat()
})