package com.backend.crm.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.backend.crm.dto.account.AccountRequest;
import com.backend.crm.dto.opportunity.OpportunityRequest;
import com.backend.crm.dto.opportunity.OpportunityResponse;
import com.backend.crm.entity.Account;
import com.backend.crm.service.AccountService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {
    private final AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }

    @PostMapping("/{id}/opportunity")
    @ResponseStatus(HttpStatus.CREATED)
    public OpportunityResponse convertLead(@PathVariable Long id, @RequestBody OpportunityRequest request) {
        return service.createNewOpportunityFromAccountId(id, request);
    }

    @GetMapping("/{id}")
    public Account getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/type/{type}")
    public List<Account> getByType(@PathVariable String type) {
        return service.getByType(type);
    }

    @GetMapping
    public List<Account> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public Account update(@PathVariable Long id,
                           @RequestBody AccountRequest acc) {
        return service.update(id, acc);
    }
    
}
