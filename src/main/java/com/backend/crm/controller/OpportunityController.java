package com.backend.crm.controller;

import org.springframework.web.bind.annotation.*;

import com.backend.crm.dto.opportunity.OpportunityRequest;
import com.backend.crm.entity.Opportunity;
import com.backend.crm.service.OpportunityService;


@RestController
@RequestMapping("/api/v1/opportunities")
public class OpportunityController {
    
    private final OpportunityService service;

    public OpportunityController(OpportunityService service){
        this.service = service;
    }

    @GetMapping("/{id}")
    public Opportunity getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Opportunity update(@PathVariable Long id,
                           @RequestBody OpportunityRequest lead) {
        return service.update(id, lead);
    }
}
