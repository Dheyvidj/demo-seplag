package com.example.demo_seplag.controller;

import com.example.demo_seplag.dto.AuthRequest;
import com.example.demo_seplag.dto.AuthResponse;
import com.example.demo_seplag.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        return authService.login(request);
    }

    @PostMapping("/refresh")
    public AuthResponse refresh(@RequestBody Map<String, String> request) {
        return authService.refresh(request);
    }
}
