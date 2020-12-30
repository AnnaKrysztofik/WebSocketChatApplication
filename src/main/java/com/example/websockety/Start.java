package com.example.websockety;

import com.example.websockety.security.AppUser;
import com.example.websockety.security.AppUserRepo;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class Start {
    private AppUserRepo appUserRepo;

    public Start(AppUserRepo appUserRepo, PasswordEncoder passwordEncoder) {
        this.appUserRepo = appUserRepo;


        AppUser appUserJanusz = new AppUser();
        appUserJanusz.setUsername("Janusz");
        appUserJanusz.setPassword(passwordEncoder.encode("123"));
        appUserJanusz.setRole("ROLE_USER");
        appUserJanusz.setEnabled(true);
        appUserRepo.save(appUserJanusz);
    }
}
