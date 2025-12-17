package com.backend.crm.dto.account;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class AccountRequest {
    private String firstName;
    private String lastName;    
    private String email;    
    private String mobile;    
}
