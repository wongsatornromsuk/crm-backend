package com.backend.crm.dto.opportunity;

import java.time.LocalDate;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class OpportunityResponse {
    private Long id;
    private String name;
    private String stage;
    private Double amount;
    private LocalDate closeDate;
}
