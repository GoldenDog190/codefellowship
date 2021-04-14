package com.GoldenDog190.codefellowship.controllers;


import com.GoldenDog190.codefellowship.models.ApplicationUser;
import com.GoldenDog190.codefellowship.models.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.time.LocalDateTime;

import org.springframework.ui.Model;


@Controller
public class ApplicationUserController {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    ApplicationUserRepository applicationUserRepository;
    
    @Autowired
    AuthenticationManager authenticationManager;


    @PostMapping("/applicationuser")
    public RedirectView createUser(String username, String password, String firstName, String lastName, int dateOfBirth, String bio, String body, LocalDateTime createdAt, HttpServletRequest request){
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

        try{
            applicationUserRepository.save(applicationUser);
        } catch (Exception e){

            return new RedirectView("/?username=duplicate" + username + "is the wrong username. Please try again.");
        }


        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        authenticationToken.setDetails(new WebAuthenticationDetails(request));
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        return new RedirectView("/");
    }

    @PostMapping("/login")
    public RedirectView createLogin(){
        return new RedirectView("/myprofile");
    }

    @GetMapping("/login")
    public String showLoginPage(){
        return "login.html";
    }

    @PostMapping("/index")
    public RedirectView createSignUpPage(){
        return new RedirectView("/myprofile");
    }

//    @GetMapping("/index")
//    public String showSignUpPage(){
//        return "index.html";
//    }

    @PostMapping("/myprofile")
    public RedirectView createMyProfile(){
        return new RedirectView("/myprofile");
    }

//    @GetMapping("/myprofile")
//    public String showUserPage() {
//        return "userprofile.html";
//    }

    @PostMapping("/applicationusers")
    public RedirectView createAdminPage(){
        return new RedirectView("/applicationusers");
    }

//    @GetMapping("/applicationusers")
//    public String showAdminPage() {
//        return "applicationusers.html";
//    }

    @GetMapping("/myprofile/{id}")
        public String showSingleUser(@PathVariable long id, Model m, Principal p) {
        ApplicationUser applicationUser = applicationUserRepository.findById(id).get();
        m.addAttribute("applicationUser", applicationUser);
        if (p != null) {
            ApplicationUser visitor = applicationUserRepository.findByUsername(p.getName());
            if (!visitor.getUsername().equals(applicationUser.getUsername())) {
                m.addAttribute("visitor", visitor);
            }

        } else {
            ApplicationUser visitor = new ApplicationUser();
            visitor.setApplicationUser("Guest");
            m.addAttribute("visitor", visitor);
        }
        return "userprofile.html";
    }

        @PutMapping("/myprofile")
        public RedirectView updateBio(@PathVariable long id, String bio, String body, LocalDateTime createdAt){
            ApplicationUser appUser = applicationUserRepository.findById(id).get();
            appUser.bio = bio;
            appUser.body = body;
            appUser.createdAt = createdAt;
            applicationUserRepository.save(appUser);
            return new RedirectView("/userprofile/" + id);

            }

}


