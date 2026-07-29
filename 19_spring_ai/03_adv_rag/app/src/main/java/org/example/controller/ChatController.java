package org.example.controller;

import org.example.service.ChatService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api/v1/chat")
public class ChatController {
    private ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping
    public ResponseEntity<String> getResponse(@RequestParam("query") String userQuery) {
        return ResponseEntity.ok(chatService.getResponse(userQuery));
    }

    @PostMapping("/weather-info")
    public ResponseEntity<String> weatherInfo(@RequestParam("query") String userQuery) {
        return ResponseEntity.ok(chatService.weatherInfo(userQuery));
    }
}
