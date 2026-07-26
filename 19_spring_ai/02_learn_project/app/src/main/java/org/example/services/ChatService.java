package org.example.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.chat.prompt.SystemPromptTemplate;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
public class ChatService {
    private final ChatClient chatClient;
    @Value("classpath:/prompts/chat-user-prompt.st")
    private Resource userPrompt;
    @Value("classpath:/prompts/chat-system-prompt.st")
    private Resource systemPrompt;

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
                .template(String.valueOf(this.systemPrompt)).build();

        var systemMessage = systemPromptTemplate.createMessage();

        var userPromptTemplate = PromptTemplate.builder().template(String.valueOf(this.userPrompt)).build();

        var renderedMessage = userPromptTemplate.createMessage(Map.of(
                "techName", "Spring",
                "exampleName", "Spring Boot"
        ));

        Prompt prompt = new Prompt(systemMessage, renderedMessage);

        return chatClient.prompt(prompt).call().content();
    }
}
