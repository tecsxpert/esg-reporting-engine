package com.example.backend.client;

import org.springframework.stereotype.Service;

@Service
public class AiServiceClient {

    public String describe(String text) {
        return "AI Response: " + text;
    }

    public String recommend(String text) {
        return "Recommendation for: " + text;
    }
}