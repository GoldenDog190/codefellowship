package com.GoldenDog190.codefellowship.controllers;


import com.GoldenDog190.codefellowship.models.ApplicationUser;
import com.GoldenDog190.codefellowship.models.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;

@Controller
public class ApplicationUserController {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @PostMapping("/applicationuser/{id}")
    public RedirectView createUser(String username, String password, String firstName, String lastName, int dateOfBirth, String bio, String body, LocalDateTime createdAt){
        password = passwordEncoder.encode(password);
        System.out.println("password= " + password);
        ApplicationUser applicationUser = new ApplicationUser();
        applicationUser.setPassword(password);
        applicationUser.setApplicationUser(username);
        applicationUser.setApplicationUser(firstName);
        applicationUser.setApplicationUser(lastName);
        applicationUser.setApplicationUser(String.valueOf(dateOfBirth));
        applicationUser.setApplicationUser(bio);
        applicationUser.setApplicationUser(body);
        applicationUser.setApplicationUser(String.valueOf(createdAt));
        return new RedirectView("/");
    }

    @GetMapping("/login")
    public String showLoginPage(){
        return "login.html";
    }


}
