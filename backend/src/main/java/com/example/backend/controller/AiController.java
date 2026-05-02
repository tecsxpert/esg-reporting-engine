package com.example.backend.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.client.AiServiceClient;

@RestController
@RequestMapping("/api/ai")
public class AiController {

    private final AiServiceClient aiServiceClient;

    public AiController(AiServiceClient aiServiceClient) {
        this.aiServiceClient = aiServiceClient;
    }

    @PostMapping("/describe")
    public String describe(@RequestBody String text) {

        if (text == null || text.trim().isEmpty()) {
            return "Error: Input text is empty";
        }

        String response = aiServiceClient.describe(text);

        if (response == null) {
            return "Error: AI service not responding";
        }

        return response; 
    }

    @PostMapping("/recommend")
    public String recommend(@RequestBody String text) {

        if (text == null || text.trim().isEmpty()) {
            return "Error: Input text is empty";
        }

        String response = aiServiceClient.recommend(text);

        if (response == null) {
            return "Error: AI service not responding";
        }

        return response; 
    }
}