package com.GoldenDog190.codefellowship.models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
public class UserPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(unique = true)

//    @CreationTimestamp
    String body;
    LocalDateTime createdAt;

    @ManyToOne
    ApplicationUser applicationUser;

    public UserPost(String body, LocalDateTime createdAt) {
        this.body = body;
        this.createdAt =createdAt;
    }

    public UserPost(){}

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public UserPost(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
