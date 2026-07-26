package org.example.services;

import lombok.extern.slf4j.Slf4j;
import org.example.entities.Tut;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class ChatService {
    private ChatClient chatClient;

    public ChatService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    public List<Tut> chat(String query) {
        Prompt prompt = new Prompt(query);

        return chatClient.prompt(prompt)
                .call().
                entity(
                        new ParameterizedTypeReference<List<Tut>>() {
                        }
                );
    }
}
