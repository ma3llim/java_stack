package org.example.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;
import org.example.dto.ExpenseDto;

import java.io.IOException;

public class ExpenseDeserializer implements Deserializer<ExpenseDto> {

    @Override
    public ExpenseDto deserialize(String topic, byte[] data) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(data, ExpenseDto.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
