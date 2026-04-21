from flask import Flask
from routes.describe import describe_bp
from flask_limiter import Limiter
from flask_limiter.util import get_remote_address
from routes.recommend import recommend_bp

app = Flask(__name__)

limiter = Limiter(
    get_remote_address,
    app=app,
    default_limits=["30 per minute"]
)

app.register_blueprint(recommend_bp)

@app.route("/")
def home():
    return {"message": "AI Service Running"}

if __name__ == "__main__":
    app.run(debug=True, port=5000)