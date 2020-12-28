package com.example.websockety.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepo extends JpaRepository<AppUser, Long> {

    // Optional<AppUser> findByUsername(String username);
    AppUser findByUsername(String username);
}
