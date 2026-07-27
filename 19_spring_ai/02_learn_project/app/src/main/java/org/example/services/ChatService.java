package org.example.services;

import lombok.extern.slf4j.Slf4j;
import org.example.advisors.UsagesPrinter;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SafeGuardAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.chat.prompt.SystemPromptTemplate;
import org.springframework.ai.document.Document;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class ChatService {
    private final ChatClient chatClient;
    private final VectorStore vectorStore;
    @Value("classpath:/prompts/users/chat-user-prompt.st")
    private Resource userPrompt;
    @Value("classpath:/prompts/users/chat-system-prompt.st")
    private Resource systemPrompt;

    public ChatService(ChatClient.Builder chatClientBuilder, ChatMemory chatMemory, VectorStore vectorStore) {
        this.vectorStore = vectorStore;
        MessageChatMemoryAdvisor messageChatMemoryAdvisor = MessageChatMemoryAdvisor.builder(chatMemory).build();
        this.chatClient = chatClientBuilder
                .defaultAdvisors(messageChatMemoryAdvisor)
                .defaultOptions(
                        OpenAiChatOptions.builder()
                                .maxTokens(100)
                                .build()
                ).build();
    }

    public String chat(String query, String userId) {
        // system prompt
        SystemPromptTemplate systemPromptTemplate = new SystemPromptTemplate(systemPrompt);
        var systemMessage = systemPromptTemplate.createMessage();
        // user prompt
        PromptTemplate userPromptTemplate = new PromptTemplate(userPrompt);
        var renderedMessage = userPromptTemplate.createMessage(Map.of(
                "concept", query
        ));

        Prompt prompt = new Prompt(systemMessage, renderedMessage);

        return chatClient.prompt(prompt)
                .advisors(advisorSpec -> advisorSpec.param(ChatMemory.CONVERSATION_ID, userId))
                .advisors(
                        new UsagesPrinter(),
                        new SimpleLoggerAdvisor(),
                        new SafeGuardAdvisor(List.of("bomb", "hack", "malware"))
                ).call().content();
    }

    public Flux<String> streamingChatResponse(String query) {
        return chatClient.prompt()
                .system(promptSystemSpec -> promptSystemSpec.text(systemPrompt))
                .user(promptUserSpec -> promptUserSpec.text(userPrompt).param("concept", query))
                .stream().content();
    }

    public String saveDataToVectorFormat(List<String> listData) {
        List<Document> documentList = listData.stream().map(Document::new).toList();
        this.vectorStore.add(documentList);
        return "Data Stored Successfully";
    }
}
