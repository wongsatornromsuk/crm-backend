package com.backend.crm.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.backend.crm.entity.Lead;

public interface LeadRepository extends JpaRepository<Lead, Long> {
    List<Lead> findByStage(String stage);
    Optional<Lead> findByIdAndStageNot(Long id, String stage);
    List<Lead> findByStageNot(String stage);
}
