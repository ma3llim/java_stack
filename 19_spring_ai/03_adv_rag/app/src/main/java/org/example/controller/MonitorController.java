package org.example.controller;

import org.example.dtos.AiResponse;
import org.example.service.ChatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ai-monitor")
public class MonitorController {
    private final ChatService chatService;

    public MonitorController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping()
    public ResponseEntity<AiResponse> askFromAi(@RequestParam("query") String userQuery) {
        return ResponseEntity.ok(chatService.getResponseWithMonitorData(userQuery));
    }
}
