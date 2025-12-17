package com.backend.crm.dto.login;

import lombok.*;

@Getter
@Builder
public class LoginResponse {
    private String accessToken;
    private String tokenType;
    private String username;
}
