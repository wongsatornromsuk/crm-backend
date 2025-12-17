package com.backend.crm.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.backend.crm.entity.Account;
import com.backend.crm.entity.Lead;
import com.backend.crm.exception.AppException;
import com.backend.crm.exception.ErrorCode;
import com.backend.crm.repository.LeadRepository;
import java.util.List;

@Service
@Transactional
public class LeadService {

    private final LeadRepository repository;
    private final AccountService accountService;

    public LeadService(LeadRepository repository, AccountService accountService) {
        this.repository = repository;
        this.accountService = accountService;
    }

    public List<Lead> getAll() {
        return repository.findAll();
    }

    public List<Lead> getByStage(String stage) {
        return repository.findByStage(stage);
    }

    public List<Lead> getByStageNotConverted() {
        return repository.findByStageNot("Converted");
    }

    public Lead getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.RESOURCE_NOT_FOUND));
    }

    public Lead create(Lead lead) {
        return repository.save(lead);
    }

    public Account convertLead(Long id){
        Lead lead = repository.findByIdAndStageNot(id,"Converted")
                .orElseThrow(() -> new AppException(ErrorCode.BUSINESS_RULE_VIOLATION,"Lead is already converted."));
        lead.setStage("Converted");
        repository.save(lead);

        Account account = new Account();
        account.setFirstName(lead.getFirstName());
        account.setLastName(lead.getLastName());
        account.setEmail(lead.getEmail());
        account.setMobile(lead.getMobile());
        account.setLead(lead);
        account.setType("Prospect");

        return accountService.create(account);
    }

    public Lead update(Long id, Lead input) {
        Lead existing = repository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.RESOURCE_NOT_FOUND));

        existing.setFirstName(input.getFirstName());
        existing.setLastName(input.getLastName());
        existing.setEmail(input.getEmail());
        existing.setMobile(input.getMobile());
        existing.setStage(input.getStage());

        return repository.save(existing);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new AppException(ErrorCode.RESOURCE_NOT_FOUND);
        }
        repository.deleteById(id);
    }
}