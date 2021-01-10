package com.example.websockety.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.Collection;

@Controller
public class UserController {

    private UserService userService;


    public UserController(UserService userService, AppUserRepo appUserRepo) {
        this.userService = userService;

    }

//    @GetMapping("/")
//    public String hello(Principal principal, Model model) {
//        model.addAttribute("username", principal.getName());
//        Collection<? extends GrantedAuthority> authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
//        Object details = SecurityContextHolder.getContext().getAuthentication().getDetails();
//        model.addAttribute("authorities", authorities);
//        model.addAttribute("details", details);
//        return "hello";
//    }
//
//    @GetMapping("/sign-up")
//    public String signUp(Model model) {
//        model.addAttribute("username", new AppUser());
//        return "sign-up";
//    }
//
//    @PostMapping("/register")
//    public String register(AppUser appUser) {
//        userService.addUser(appUser);
//        return "sign-up";
//    }
@GetMapping("/hello")
public String hello(Principal principal, Model model) {
    model.addAttribute("name", principal.getName());
    Collection<? extends GrantedAuthority> authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
    Object details = SecurityContextHolder.getContext().getAuthentication().getDetails();
    model.addAttribute("authorities", authorities);
    model.addAttribute("details", details);
    return "hello";
}
   @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

  @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/")
    public String chat(Principal principal, Model model) {
        model.addAttribute("name", principal.getName());
        Collection<? extends GrantedAuthority> authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        Object details = SecurityContextHolder.getContext().getAuthentication().getDetails();
        model.addAttribute("authorities", authorities);
        model.addAttribute("details", details);
        return "index";
    }
   @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/sign-up")
    public String singUp(Model model) {
        model.addAttribute("user", new AppUser());
     return "sign-up";

    }

    @PostMapping("/register")
    public String register(AppUser appUser) {
        userService.addUser(appUser);
      // return "sign-up";
        return "login";
    }

}
