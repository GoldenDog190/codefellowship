package com.GoldenDog190.codefellowship.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller

public class ApplicationController {

    @GetMapping("/")
    public String showHomePage(Principal p){
        System.out.println("p" + p);
        if(p != null){
            System.out.println("p.getName() = " + p.getName());
        }
        return "index";
    }

    @GetMapping("/")
    public String showSplashPage(Principal p){
        return "splashpage.html";
    }

    @GetMapping("/applicationusers")
    public String showUsers(Principal p, Model m){
        System.out.println("p.getUsername = " + p.getName());

        m.addAttribute("username", p.getName());
        return "applicationusers";
    }

    @GetMapping("/*")
    public String catchAll(){
        return "userprofile.html";
    }

}
