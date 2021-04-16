package com.GoldenDog190.codefellowship.controllers;
import com.GoldenDog190.codefellowship.models.ApplicationUserRepository;
import com.GoldenDog190.codefellowship.models.ApplicationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.List;

@Controller

public class ApplicationController {
    @Autowired
    ApplicationUserRepository applicationUserRepository;


    @GetMapping("/")
    public String showHomePage(Principal p, Model m){
        System.out.println("p" + p);
        if(p != null){
            System.out.println("p.getName() = " + p.getName());
            m.addAttribute("user", p.getName());
        }
        return "index.html";
    }

    @GetMapping("/home")
        public String goToHome(){
        return "splashpage.html";
    }

    @GetMapping("/userprofile")
    public String showUsers(Principal p, Model m){
        System.out.println("p.getUsername = " + p.getName());
        m.addAttribute("user", p.getName());

        List<ApplicationUser> applicationUsers = applicationUserRepository.findAll();
        m.addAttribute("followers", applicationUsers);

        return "userprofile.html";
    }

    @GetMapping("/*")
    public String catchAll(){
        return "userprofile.html";
    }

    @PostMapping("/following")
    public RedirectView showFollowers(String firstName, String lastName){
        // search users by user name, change html, create an html file called find html
       // ApplicationUser appUser = applicationUserRepository.findByUsername();

//        applicationUserRepository.save(applicationUser);
        return new RedirectView("/userprofile");
    }

    @PostMapping("/followersFeed")
    public RedirectView giveFollowers(long giverId, long receiverId){
        ApplicationUser giver = applicationUserRepository.findById(giverId).get();
        ApplicationUser receiver = applicationUserRepository.findById(receiverId).get();

        giver.getUsersFollowReceived().add(receiver);

        applicationUserRepository.save(receiver);

        return new RedirectView("/userprofile");
    }
}
