package com.backend.crm.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.backend.crm.entity.AppUser;
import com.backend.crm.repository.AppUserRepository;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner seedUser(AppUserRepository repo, PasswordEncoder encoder) {
        return args -> {
            if (!repo.existsByUsername("admin")) {
                repo.save(
                        AppUser.builder()
                                .username("admin")
                                .email("admin@example.com")
                                .passwordHash(encoder.encode("admin1234"))
                                .enabled(true)
                                .build()
                );
            }
        };
    }
}
