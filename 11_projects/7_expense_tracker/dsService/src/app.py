from flask import Flask
from flask import request
from flask import jsonify
from service.MessageService import MessageService

app = Flask(__name__)

message_service = MessageService()

@app.route("/v1/ds/message", methods=["POST"])
def handle_message():
    data = request.get_json(silent=True) or {}
    message = data.get("message")

    if not message:
        return jsonify(
            {"error": "Message Is Required"}
        ), 400
    
    result = message_service.process_message(message)

    return jsonify(result)


if __name__ == "__main__":
    app.run(
        host="localhost",
        port=8000,
        debug=True
    )