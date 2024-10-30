package com.aecode.webcoursesback.dtos;

import java.util.List;

public class UserProfileDTO {
    private int userId;
    private String fullname;
    private String email;
    private String passwordHash;
    private List<UserProgressSessionDTO> userprogresssessions;
    private List<UserCourseDTO> usercourseaccess;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
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

    public List<UserProgressSessionDTO> getUserprogresssessions() {
        return userprogresssessions;
    }

    public void setUserprogresssessions(List<UserProgressSessionDTO> userprogresssessions) {
        this.userprogresssessions = userprogresssessions;
    }

    public List<UserCourseDTO> getUsercourseaccess() {
        return usercourseaccess;
    }

    public void setUsercourseaccess(List<UserCourseDTO> usercourseaccess) {
        this.usercourseaccess = usercourseaccess;
    }
}
