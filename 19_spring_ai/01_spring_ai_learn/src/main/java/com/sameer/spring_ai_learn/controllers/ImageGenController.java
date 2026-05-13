package com.sameer.spring_ai_learn.controllers;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.openai.OpenAiImageModel;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/image/")
public class ImageGenController {
    private ChatClient chatClient;
    private OpenAiImageModel openAiImageModel;

    public ImageGenController(OpenAiImageModel openAiImageModel, ChatClient.Builder builder){
        this.openAiImageModel = openAiImageModel;
        chatClient = builder.build();
    }

    @PostMapping("generate-image/{query}")
    public String generateImage(@PathVariable String query){
        ImagePrompt prompt = new ImagePrompt(query);
        ImageResponse response = openAiImageModel.call(prompt);
        return response.getResult().getOutput().getUrl();
    }
}
