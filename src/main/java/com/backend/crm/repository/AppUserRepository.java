package com.backend.crm.repository;


import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.backend.crm.entity.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByUsername(String username);
    Boolean existsByUsername(String username);
}
