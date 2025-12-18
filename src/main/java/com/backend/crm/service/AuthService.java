package com.backend.crm.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.backend.crm.dto.login.LoginRequest;
import com.backend.crm.dto.login.LoginResponse;
import com.backend.crm.entity.AppUser;
import com.backend.crm.exception.AppException;
import com.backend.crm.exception.ErrorCode;
import com.backend.crm.repository.AppUserRepository;
import com.backend.crm.security.JwtService;

@Service
public class AuthService {

    private final AppUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(AppUserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public LoginResponse login(LoginRequest req) {
        AppUser user = userRepository.findByUsername(req.getUsername())
                .orElseThrow(() ->
                        new AppException(ErrorCode.INVALID_REQUEST, "Invalid username or password")
                );

        if (!user.isEnabled()) {
            throw new AppException(ErrorCode.BUSINESS_RULE_VIOLATION, "User is disabled");
        }

        if (!passwordEncoder.matches(req.getPassword(), user.getPasswordHash())) {
            throw new AppException(ErrorCode.INVALID_REQUEST, "Invalid username or password");
        }

        user.setCount(user.getCount()+1);
        
        String token = jwtService.generateToken(user.getUsername());

        return LoginResponse.builder()
                .accessToken(token)
                .tokenType("Bearer")
                .username(user.getUsername())
                .build();
    }
}

