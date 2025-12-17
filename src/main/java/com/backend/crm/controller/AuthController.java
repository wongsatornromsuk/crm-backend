package com.backend.crm.controller;

import com.backend.crm.dto.login.LoginRequest;
import com.backend.crm.dto.login.LoginResponse;
import com.backend.crm.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest req) {
        return authService.login(req);
    }
}
