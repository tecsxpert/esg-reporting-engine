from flask import Flask, request, jsonify
from flask_limiter import Limiter
from flask_limiter.util import get_remote_address
from routes.describe import describe_bp
from routes.recommend_v2 import recommend_bp
from routes.generate_report import generate_report_bp
from routes.health import health_bp
from services.embedding_service import init_embedding_model

app = Flask(__name__)

@app.before_request
def require_jwt():
    if app.config.get("TESTING"):
        return None
    if request.path == "/" or request.path == "/health":
        return None
    auth_header = request.headers.get("Authorization")
    if not auth_header or auth_header != "Bearer test-jwt-token":
        return jsonify({"error": "Unauthorized: Invalid or missing JWT"}), 401

limiter = Limiter(
    get_remote_address,
    app=app,
    default_limits=["30 per minute"]
)

@app.after_request
def set_security_headers(response):
    response.headers['X-Content-Type-Options'] = 'nosniff'
    response.headers['X-Frame-Options'] = 'DENY'
    response.headers['X-XSS-Protection'] = '1; mode=block'
    response.headers['Strict-Transport-Security'] = 'max-age=31536000; includeSubDomains'
    response.headers['Content-Security-Policy'] = "default-src 'self';"
    response.headers['Server'] = 'Hidden'
    return response

app.register_blueprint(describe_bp)
app.register_blueprint(recommend_bp)
app.register_blueprint(generate_report_bp)
app.register_blueprint(health_bp)

@app.route("/")
def home():
    return {"message": "AI Service Running"}

# Pre-load models at startup (Day 11 requirement)
init_embedding_model()

if __name__ == "__main__":
    app.run(debug=True)