package com.example.backend.controller;

import com.example.backend.client.AiServiceClient;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ai")
public class AiController {

    private final AiServiceClient aiServiceClient;

    public AiController(AiServiceClient aiServiceClient) {
        this.aiServiceClient = aiServiceClient;
    }

    @PostMapping("/describe")
    public String describe(@RequestBody String text) {
        return aiServiceClient.describe(text);
    }

    @PostMapping("/recommend")
    public String recommend(@RequestBody String text) {
        return aiServiceClient.recommend(text);
    }
}