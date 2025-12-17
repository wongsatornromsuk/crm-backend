package com.backend.crm.dto.opportunity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class OpportunityRequest {
    private String name;
    private String stage;    
    private Double amount;
}
