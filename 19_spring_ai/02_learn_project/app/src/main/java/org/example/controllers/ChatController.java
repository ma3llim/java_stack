package org.example.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api/v1/chat")
public class ChatController {
    private final ChatClient chatClient;

    public ChatController(ChatClient.Builder builder){
        this.chatClient = builder.build();
    }

    @GetMapping
    public ResponseEntity<String> chat(@RequestParam(value = "query", required = true) String query){
        var resultResponse = chatClient.prompt(query).call().content();

        return ResponseEntity.ok(resultResponse);
    }
}
