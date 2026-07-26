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
    @Value("classpath:/prompts/users/chat-user-prompt.st")
    private Resource userPrompt;
    @Value("classpath:/prompts/users/chat-system-prompt.st")
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
        // system prompt
        SystemPromptTemplate systemPromptTemplate = new SystemPromptTemplate(systemPrompt);
        var systemMessage = systemPromptTemplate.createMessage();
        // user prompt
        PromptTemplate userPromptTemplate = new PromptTemplate(userPrompt);
        var renderedMessage = userPromptTemplate.createMessage(Map.of(
                "techName", query
        ));

        Prompt prompt = new Prompt(systemMessage, renderedMessage);

        return chatClient.prompt(prompt).call().content();
    }
}
