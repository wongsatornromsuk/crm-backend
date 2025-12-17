package com.backend.crm.dto.login;

import lombok.*;

@Getter
@Setter
public class LoginRequest {
    private String username;
    private String password;
}