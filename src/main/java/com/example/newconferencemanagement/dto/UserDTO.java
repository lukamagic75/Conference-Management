package com.example.newconferencemanagement.dto;

import com.example.newconferencemanagement.model.User;

public class UserDTO {
    private Long id;
    private String username;
    private String nickname;
    private String phoneNumber;
    private String email;
    private String status;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User toEntity() {
        User user = new User();
        user.setId(this.id);
        user.setUsername(this.username);
        user.setNickname(this.nickname);
        user.setPhoneNumber(this.phoneNumber);
        user.setEmail(this.email);
        user.setStatus(this.status);
        return user;
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.nickname = user.getNickname();
        this.phoneNumber = user.getPhoneNumber();
        this.email = user.getEmail();
        this.status = user.getStatus();
    }
}
