package com.aecode.webcoursesback.dtos;

public class LoginDTO {
    private int userId;
    private String email;
    private String passwordHash;

    public LoginDTO() {
    }

    public LoginDTO( String email, String passwordHash) {
        this.email = email;
        this.passwordHash = passwordHash;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
}
