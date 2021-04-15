package com.GoldenDog190.codefellowship.models;



import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ApplicationUser implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(unique = true)
    String username;
    String password;

    String firstName;
    String lastName;
    int dateOfBirth;
    @Column(columnDefinition = "Text")
    public String bio;

//    @CreationTimestamp
    public String body;
    public LocalDateTime createdAt;

    @ManyToOne(cascade = CascadeType.REMOVE)
    ApplicationUser applicationUser;

    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(
            name="user_followers",
            joinColumns = {@JoinColumn(name="giver")},
            inverseJoinColumns = {@JoinColumn(name="receiver")}
    )
    Set<ApplicationUser> usersFollowTo = new HashSet<>();

    @ManyToMany(mappedBy = "usersFollowTo")
    Set<ApplicationUser> usersFollowReceived = new HashSet<>();

    public void setApplicationUser(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDateOfBirth(int dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setBio(String bio){
        this.bio = bio;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDateOfBirth() {
        return dateOfBirth;
    }

    public String getBio() {
        return bio;
    }

    public String getBody() {
        return body;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public long getId() {
        return id;
    }

    public Set<ApplicationUser> getUsersFollowTo() {
        return usersFollowTo;
    }

    public Set<ApplicationUser> getUsersFollowReceived() {
        return usersFollowReceived;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
