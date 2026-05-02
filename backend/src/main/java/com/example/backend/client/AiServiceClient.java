package com.example.backend.client;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AiServiceClient {

    private final RestTemplate restTemplate = new RestTemplate();

    // 🔹 DESCRIBE
    public String describe(String text) {
        String url = "http://127.0.0.1:5000/describe";

        try {
            return restTemplate.postForObject(url, text, String.class);
        } catch (Exception e) {
            return "Error calling AI service";
        }
    }

    // 🔹 RECOMMEND
    public String recommend(String text) {
        String url = "http://127.0.0.1:5000/recommend";

        try {
            return restTemplate.postForObject(url, text, String.class);
        } catch (Exception e) {
            return "Error calling AI service";
        }
    }
}