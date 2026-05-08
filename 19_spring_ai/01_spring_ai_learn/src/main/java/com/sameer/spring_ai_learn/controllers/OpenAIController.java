package com.sameer.spring_ai_learn.controllers;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.document.Document;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.scheduler.Schedulers;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/ai/")
public class OpenAIController {
    private final ChatClient chatClient;
    private final ChatMemory chatMemory;
    @Autowired
    private EmbeddingModel embeddingModel;
    @Autowired
    private VectorStore vectorStore;

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


    @PostMapping("/embeddings")
    public float[] embedding(@RequestParam String text){
        return  embeddingModel.embed(text);
    }

    @PostMapping("/similarity")
    public double similarity(@RequestParam String text1, @RequestParam String text2){
        float[] embedding1 = embeddingModel.embed(text1);
        float[] embedding2 = embeddingModel.embed(text2);

        double dotProduct = 0;
        double norm1 = 0;
        double norm2 = 0;
        for(int i=0; i < embedding1.length; i++){
            dotProduct += embedding1[i] * embedding2[i];
            norm1 += Math.pow(embedding1[i], 2);
            norm2 += Math.pow(embedding2[i], 2);
        }

        return  dotProduct / (Math.sqrt(norm1) * Math.sqrt(norm2));
    }

    @PostMapping("/product")
    public List<Document> getProduct(@RequestParam String text){
        return vectorStore.similaritySearch(SearchRequest.builder().query(text).topK(2).build());
    }
}