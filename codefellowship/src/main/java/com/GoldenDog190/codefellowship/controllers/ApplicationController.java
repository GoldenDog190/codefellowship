package com.GoldenDog190.codefellowship.controllers;
import com.GoldenDog190.codefellowship.models.ApplicationUserRepository;
import com.GoldenDog190.codefellowship.models.ApplicationUser;
import com.GoldenDog190.codefellowship.models.PostRepository;
import com.GoldenDog190.codefellowship.models.UserPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

@Controller

public class ApplicationController {
    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @Autowired
    PostRepository postRepository;


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

    @PostMapping("/addPost")
    public RedirectView addPost(String body,  LocalDateTime createdAt, Long id){
        ApplicationUser user = applicationUserRepository.findById(id).get();
        user.setBody(body);
        user.setCreatedAt(createdAt);
        UserPost post = new UserPost();
        postRepository.save(post);
        return new RedirectView("/userprofile");
    }

    @GetMapping("/*")
    public String catchAll(){
        return "userprofile.html";
    }

    @PostMapping("/following")
    public RedirectView showFollowers(String name){

        ApplicationUser following = new ApplicationUser();
        following.setName(name);
        ApplicationUser appUser = applicationUserRepository.findByUsername(name);

        applicationUserRepository.save(appUser);
        return new RedirectView("/following");
    }

    @PostMapping("/followersFeed")
    public RedirectView giveFollowers(long giverId, long receiverId){
        ApplicationUser giver = applicationUserRepository.findById(giverId).get();
        ApplicationUser receiver = applicationUserRepository.findById(receiverId).get();

        giver.getUsersFollowReceived().add(receiver);

        applicationUserRepository.save(receiver);

        return new RedirectView("/following");
    }
}
