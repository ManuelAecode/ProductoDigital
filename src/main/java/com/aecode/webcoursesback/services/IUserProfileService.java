package com.aecode.webcoursesback.services;

import com.aecode.webcoursesback.dtos.LoginDTO;
import com.aecode.webcoursesback.dtos.UserProfileDTO;
import com.aecode.webcoursesback.entities.UserProfile;

import java.util.List;

public interface IUserProfileService {
    public void insert(UserProfileDTO userdto);
    List<UserProfile> list();
    public void delete(int userId);
    public UserProfile listId(int userId);
    public void update(UserProfile userprofile);
    public UserProfile authenticateUser(LoginDTO logindto);
}
