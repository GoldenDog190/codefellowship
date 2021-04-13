package com.GoldenDog190.codefellowship.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller

public class ApplicationController {

    @GetMapping("/")
    public String ShowSplashPage(Principal p){
        System.out.println("p" + p);
        if(p != null){
            System.out.println("p.getName() = " + p.getName());
        }
        return "splashpage.html";
    }

    @GetMapping("/applicationUsers")
    public String showUsers(Principal p, Model m){
        System.out.println("p.getName() = " + p.getName());

        m.addAttribute("user", p.getName());
        return "applicationUsers";
    }

}
