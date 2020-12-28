package com.example.websockety.security;
import com.example.websockety.security.AppUser;
import com.example.websockety.security.AppUserRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    private AppUserRepo appUserRepo;
    private PasswordEncoder passwordEncoder;

    public UserService(AppUserRepo appUserRepo, PasswordEncoder passwordEncoder) {
        this.appUserRepo = appUserRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public void addUser(AppUser appUser) {
      //  if (appUser.getUsername().equals(appUserRepo.findByUsername(appUser.getUsername()))) return "Username is already taken ";
      //  else {
          //  appUser.setId(Long.valueOf(UUID.randomUUID().toString()));
            appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
            appUser.setEnabled(true);
            appUser.setRole("ROLE_USER");
            appUserRepo.save(appUser);
     //   }
//        return "Registration Successful\n" +
//                "Thank you for registering.";
    }



}
