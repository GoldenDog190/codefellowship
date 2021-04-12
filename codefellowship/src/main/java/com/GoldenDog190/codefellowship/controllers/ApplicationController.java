package com.GoldenDog190.codefellowship.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class ApplicationController {

    @GetMapping("/")
    public String ShowSplashPage(){
        return "splashpage.html";
    }

}
