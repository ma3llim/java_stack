package org.example.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ChatService {
    private ChatClient chatClient;

    public ChatService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    public String chat(String query) {
        Prompt prompt = new Prompt(query);
        // modify this prompt and extra things to prompt make it more interactive
        String queryStr = "As an expert in coding and programming. Always write program in java.";

        return chatClient.prompt().user(u -> u.text(queryStr).param("query", queryStr))
                .call().content();
    }
}
