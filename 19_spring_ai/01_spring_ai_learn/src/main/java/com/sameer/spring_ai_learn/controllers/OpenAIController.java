package com.sameer.spring_ai_learn.controllers;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.scheduler.Schedulers;

@RestController
@RequestMapping("/api/v1/ai/")
public class OpenAIController {
    private final ChatClient chatClient;
    private final ChatMemory chatMemory;

    public OpenAIController(ChatClient.Builder builder) {
        this.chatMemory = MessageWindowChatMemory.builder()
                .maxMessages(10)
                .build();

        MessageChatMemoryAdvisor advisor = MessageChatMemoryAdvisor.builder(chatMemory)
                .conversationId("default")
                .scheduler(Schedulers.boundedElastic())
                .build();

        this.chatClient = builder
                .defaultAdvisors(advisor)
                .build();
    }

    @GetMapping("{message}")
    public ResponseEntity<String> getAnswer(
            @PathVariable String message,
            @RequestParam(defaultValue = "default") String conversationId) {

        ChatResponse chatResponse = chatClient.prompt()
                .advisors(advisor -> advisor.param(ChatMemory.CONVERSATION_ID, conversationId))
                .user(message)
                .call()
                .chatResponse();

        System.out.println("Model: " + chatResponse.getMetadata().getModel());
        String response = chatResponse.getResult().getOutput().getText();
        System.out.println("Response: " + response);

        return ResponseEntity.ok(response != null ? response : "No response");
    }
}