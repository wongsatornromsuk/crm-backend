package com.backend.crm.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.backend.crm.dto.account.AccountRequest;
import com.backend.crm.dto.opportunity.OpportunityRequest;
import com.backend.crm.dto.opportunity.OpportunityResponse;
import com.backend.crm.entity.Account;
import com.backend.crm.entity.Opportunity;
import com.backend.crm.exception.AppException;
import com.backend.crm.exception.ErrorCode;
import com.backend.crm.repository.AccountRepository;
import com.backend.crm.repository.OpportunityRepository;

import java.util.List;

@Service
@Transactional
public class AccountService {
    
    private final AccountRepository repository;
    private final OpportunityRepository opportunityRepository;

    public AccountService(AccountRepository repository,OpportunityRepository opportunityRepository) {
        this.repository = repository;
        this.opportunityRepository = opportunityRepository;
    }

    public List<Account> getAll() {
        return repository.findAll();
    }

    public List<Account> getByType(String type) {
        return repository.findByType(type);
    }

    public Account getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.RESOURCE_NOT_FOUND));
    }

    public Account create(Account account) {
        return repository.save(account);
    }

    public OpportunityResponse createNewOpportunityFromAccountId(Long id,OpportunityRequest request){
        Account account = this.repository.findById(id).orElseThrow(() -> new AppException(ErrorCode.RESOURCE_NOT_FOUND));
        Opportunity opportunity = new Opportunity();
        opportunity.setAccountId(account.getId());
        opportunity.setName(request.getName());
        opportunity.setAmount(request.getAmount());
        opportunity.setStage(request.getStage());

        opportunity = this.opportunityRepository.save(opportunity);

        OpportunityResponse response = new OpportunityResponse();
        response.setAmount(opportunity.getAmount());
        response.setId(opportunity.getId());
        response.setName(opportunity.getName());
        response.setStage(opportunity.getStage());
        return response;
    }

    public Account update(Long id, AccountRequest input) {
        Account existing = repository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.RESOURCE_NOT_FOUND));

        existing.setFirstName(input.getFirstName());
        existing.setLastName(input.getLastName());
        existing.setEmail(input.getEmail());
        existing.setMobile(input.getMobile());

        return existing;
    }
}
