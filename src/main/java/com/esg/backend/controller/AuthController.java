package com.esg.backend.controller;

import com.esg.backend.security.JwtUtil;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {

    @PostMapping("/login")
    public Map<String, String> login(
            @RequestBody Map<String, String> user
    ) {

        String username = user.get("username");
        String password = user.get("password");

        // SIMPLE LOGIN CHECK
        if (
                username.equals("admin")
                        &&
                        password.equals("admin123")
        ) {

            String token =
                    JwtUtil.generateToken(username);

            Map<String, String> response =
                    new HashMap<>();

            response.put("token", token);

            return response;
        }

        throw new RuntimeException(
                "Invalid credentials"
        );
    }
}