package org.example.consumer;

import lombok.RequiredArgsConstructor;
import org.example.dto.ExpenseDto;
import org.example.service.ExpenseService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExpenseConsumer {
    private final ExpenseService expenseService;

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void listen(ExpenseDto eventData) {
        try {
            expenseService.createExpense(eventData);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("ExpenseServiceConsumer: Exception is thrown while consuming kafka event");
        }
    }
}
