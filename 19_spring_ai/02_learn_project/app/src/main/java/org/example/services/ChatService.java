package org.example.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.chat.prompt.SystemPromptTemplate;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
public class ChatService {
    private final ChatClient chatClient;

    public ChatService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder
                .defaultOptions(
                        OpenAiChatOptions.builder()
                                .maxTokens(200)
                                .build()
                ).build();
    }

    public String chat(String query) {
        var systemPromptTemplate = SystemPromptTemplate.builder()
                .template("you are a helpful coding assistant. you are an expert in coding").build();
        var systemMessage = systemPromptTemplate.createMessage();

        var userPromptTemplate = PromptTemplate.builder().template("What is {techName}? tell me example of {exampleName}").build();
        String renderedMessage = userPromptTemplate.render(Map.of(
                "techName", "Spring",
                "exampleName", "Spring Boot"
        ));

        Prompt prompt = new Prompt(renderedMessage);
        return chatClient.prompt(prompt).call().content();
    }
}
