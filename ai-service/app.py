from flask import Flask
from routes.describe import describe_bp
from routes.recommend_v2 import recommend_bp

app = Flask(__name__)

app.register_blueprint(describe_bp)
app.register_blueprint(recommend_bp)

if __name__ == "__main__":
    app.run(debug=True)

    