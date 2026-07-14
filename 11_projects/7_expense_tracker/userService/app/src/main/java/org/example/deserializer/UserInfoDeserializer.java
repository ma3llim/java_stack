package org.example.deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;
import org.example.entities.UserInfoDto;

import java.io.IOException;

public class UserInfoDeserializer implements Deserializer<UserInfoDto> {

    @Override
    public UserInfoDto deserialize(String s, byte[] bytes) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(bytes, UserInfoDto.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
