package com.GoldenDog190.codefellowship.controllers;


import com.GoldenDog190.codefellowship.models.ApplicationUser;
import com.GoldenDog190.codefellowship.models.ApplicationUserRepository;
import com.GoldenDog190.codefellowship.models.PostRepository;
import com.GoldenDog190.codefellowship.models.UserPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class PostController {
    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @Autowired
    PostRepository postRepository;

    @PostMapping("/myposts")
    public RedirectView addPost(String body, LocalDateTime createdAt, long id) throws IOException {
        UserPost post = new UserPost(body, createdAt);
        ApplicationUser appUser = applicationUserRepository.getOne(id);
        postRepository.save(post);
        System.out.println("post = " + post.getId());
        return new RedirectView("/myprofile");
    }

    @GetMapping("/myposts")
    public String postContent(Model m){
        List<UserPost> postsList = postRepository.findAll();
        m.addAttribute("post", postsList);

        return "userprofile.html";
    }

}
