package org.example.eventProducer;

import org.example.model.UserInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class UserInfoProducer {
    private final KafkaTemplate<String, UserInfoDTO> kafkaTemplate;
    @Value("${spring.kafka.topic.name}")
    private String TOPIC_NAME;

    @Autowired
    UserInfoProducer(KafkaTemplate<String, UserInfoDTO> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendEventTOKafka(UserInfoDTO userInfo) {
        Message<UserInfoDTO> message = MessageBuilder.withPayload(userInfo).setHeader(KafkaHeaders.TOPIC, TOPIC_NAME).build();
        kafkaTemplate.send(message).whenComplete((result, exception) -> {
            if (exception != null) {
                System.out.println("Kafka message failed: " + exception.getMessage());
            } else {
                System.out.println(
                        "Kafka message sent successfully to topic: "
                                + result.getRecordMetadata().topic()
                                + " partition: "
                                + result.getRecordMetadata().partition()
                );
            }
        });
    }
}
