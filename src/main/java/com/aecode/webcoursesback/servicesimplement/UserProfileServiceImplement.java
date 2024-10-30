package com.aecode.webcoursesback.servicesimplement;

import com.aecode.webcoursesback.dtos.LoginDTO;
import com.aecode.webcoursesback.dtos.UserProfileDTO;
import com.aecode.webcoursesback.entities.UserProfile;
import com.aecode.webcoursesback.repositories.IUserProfileRepository;
import com.aecode.webcoursesback.services.IUserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProfileServiceImplement implements IUserProfileService {
    @Autowired
    private IUserProfileRepository upR;
    @Override
    public void insert(UserProfileDTO userdto) {
        if (upR.existsByProfile_email(userdto.getEmail())) {
            throw new RuntimeException("El correo electrónico ya está en uso");
        }
        UserProfile userProfile = new UserProfile();
        userProfile.setFullname(userdto.getFullname());
        userProfile.setEmail(userdto.getEmail());
        userProfile.setPasswordHash(userdto.getPasswordHash());
        upR.save(userProfile);
    }

    @Override
    public List<UserProfile> list() {
        return upR.findAll();
    }

    @Override
    public void delete(int userId) {
        upR.deleteById(userId);
    }

    @Override
    public UserProfile listId(int userId) {
        return upR.findById(userId).orElse(new UserProfile());
    }

    @Override
    public void update(UserProfile userprofile) {
        upR.save(userprofile);
    }

    @Override
    public UserProfile authenticateUser(LoginDTO logindto) {
        UserProfile profile = upR.findByEmail(logindto.getEmail());
        if (profile != null && profile.getPasswordHash().equals(logindto.getPasswordHash())) {
            return profile; // Devolver el perfil solo si las credenciales son válidas
        }
        return null;
    }
}
