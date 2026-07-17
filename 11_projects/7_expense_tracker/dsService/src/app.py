import json
import os
from flask import Flask
from flask import request
from flask import jsonify
from service.MessageService import MessageService
from kafka import KafkaProducer
import logging

app = Flask(__name__)
logger = logging.getLogger(__name__)
logging.basicConfig(level=logging.INFO)
message_service = MessageService()

producer = KafkaProducer(
    bootstrap_servers=os.getenv("BOOTSTRAP_SERVERS"),
    value_serializer=lambda v: json.dumps(v).encode("utf-8")
)


@app.route("/v1/ds/message", methods=["POST"])
def handle_message():
    data = request.get_json(silent=True) or {}
    message = data.get("message")

    if not message:
        return jsonify({"error": "Message Is Required"}), 400
    
    result = message_service.process_message(message)
    try:
        response = producer.send("expense-events",value=result)
        metadata = response.get(timeout=10)

        logger.info("Kafka message sent successfully | topic=%s partition=%s offset=%s",metadata.topic,metadata.partition,metadata.offset)
        producer.flush()

    except Exception as e:
        logger.exception("Failed to publish message to Kafka topic expense-events")
        return jsonify({"error": str(e)}), 500

    return jsonify(result)


if __name__ == "__main__":
    app.run(
        host="localhost",
        port=8000,
        debug=True
    )