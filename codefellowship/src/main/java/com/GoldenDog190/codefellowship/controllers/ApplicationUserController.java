package com.GoldenDog190.codefellowship.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class ApplicationUserController {


    @PostMapping("/applicationUser")
    public RedirectView createUser(String username, String password, String firstName, String lastName, int dateOfBirth, String bio){
        return new RedirectView("/");
    }

    @GetMapping("/login")
    public String showLoginPage(){
        return "login.html";
    }
}
