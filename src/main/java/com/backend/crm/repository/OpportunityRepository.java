package com.backend.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.backend.crm.entity.Opportunity;

public interface OpportunityRepository extends JpaRepository<Opportunity, Long> {
    
}
