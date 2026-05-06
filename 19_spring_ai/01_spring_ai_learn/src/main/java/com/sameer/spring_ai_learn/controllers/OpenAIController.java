package com.sameer.spring_ai_learn.controllers;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.scheduler.Schedulers;

import java.util.Map;

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
    public ResponseEntity<String> getAnswer(@PathVariable String message, @RequestParam(defaultValue = "default") String conversationId) {

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

    @GetMapping("recommend")
    public String recommend(@RequestParam String type, @RequestParam String year, @RequestParam String language){
        String tempt = """
               I want to watch a {type} movie tonight with good rating,
               looking for movies around this year {year}.
               The language im looking for is {language}
               Suggest one specific movie and tell me the cast and length of the movie.
               
               Response format should be: 
               1. movie name
               2. basic plot
               3. cast 
               4. length
               5. IMDB rating 
               """;
        PromptTemplate promptTemplate = new PromptTemplate(tempt);
        Prompt prompt = promptTemplate.create(Map.of("type", type, "year", year, "language", language));

        String response = chatClient.prompt(prompt).call().content();

        return response;
    }
}