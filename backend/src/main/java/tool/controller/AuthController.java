package tool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tool.dto.LoginRequest;
import tool.dto.LoginResponse;
import tool.security.JwtUtil;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public LoginResponse login(
            @RequestBody LoginRequest request
    ) {

        if (
                request.getUsername().equals("admin")
                        &&
                request.getPassword().equals("admin123")
        ) {

            String token =
                    jwtUtil.generateToken(
                            request.getUsername()
                    );

            return new LoginResponse(token);
        }

        throw new RuntimeException(
                "Invalid username or password"
        );
    }
}