package org.example.controllers;

import org.example.services.ChatService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.List;

@Controller
@RequestMapping("/api/v1/chat")
public class ChatController {
    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping
    public ResponseEntity<String> chat(@RequestParam(value = "query", required = true) String query, @RequestHeader("userId") String userId) {
        return ResponseEntity.ok(chatService.chat(query, userId));
    }

    @GetMapping("/stream-chat")
    public ResponseEntity<Flux<String>> streamChat(@RequestParam(value = "query", required = true) String query) {
        return ResponseEntity.ok(chatService.streamingChatResponse(query));
    }

    @PostMapping("/data-to-vector")
    public ResponseEntity<String> dataToVector(@RequestBody List<String> data) {
        return ResponseEntity.ok(chatService.saveDataToVectorFormat(data));
    }
}
