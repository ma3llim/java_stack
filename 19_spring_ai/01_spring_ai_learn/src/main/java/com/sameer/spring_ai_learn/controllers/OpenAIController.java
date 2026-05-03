package com.sameer.spring_ai_learn.controllers;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ai/")
public class OpenAIController {
    private OpenAiChatModel openAiChatModel;

    public OpenAIController(OpenAiChatModel openAiChatModel){
        this.openAiChatModel = openAiChatModel;
    }

    @GetMapping("{message}")
    public String  getAnswer(@PathVariable String message){
        String response = openAiChatModel.call(message);
        System.out.println(response);
        return response;
    }
}
