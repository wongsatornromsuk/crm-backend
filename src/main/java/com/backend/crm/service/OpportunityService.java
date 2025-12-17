package com.backend.crm.service;

import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;
import com.backend.crm.dto.opportunity.OpportunityRequest;
import com.backend.crm.entity.Account;
import com.backend.crm.entity.Opportunity;
import com.backend.crm.exception.AppException;
import com.backend.crm.exception.ErrorCode;
import com.backend.crm.repository.AccountRepository;
import com.backend.crm.repository.OpportunityRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class OpportunityService {

    private final OpportunityRepository repository;
    private final AccountRepository accRepository;

    public OpportunityService(OpportunityRepository repository,AccountRepository accRepository){
        this.repository = repository;
        this.accRepository = accRepository;
    }

    public List<Opportunity> getAll() {
        return repository.findAll();
    }

    public Opportunity getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.RESOURCE_NOT_FOUND));
    }

    public Opportunity create(Opportunity opportunity) {
        return repository.save(opportunity);
    }

    public Opportunity update(Long id, OpportunityRequest input) {
        Opportunity existing = repository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.RESOURCE_NOT_FOUND));

        if(!input.getName().equals(""))
            existing.setName(input.getName());
        if(!input.getStage().equals(""))
            existing.setStage(input.getStage());
        if(input.getAmount() != null)
            existing.setAmount(input.getAmount());

        if(input.getStage().equals("Closed Lost")){
            existing.setCloseDate(LocalDate.now());
        }

        if(input.getStage().equals("Closed Won")){
            existing.setCloseDate(LocalDate.now());

            Account account = this.accRepository.findById(existing.getAccountId()).orElseThrow(() -> new AppException(ErrorCode.RESOURCE_NOT_FOUND));

            account.setType("Customer");
            
        }

        return repository.save(existing);
    }
    
}
