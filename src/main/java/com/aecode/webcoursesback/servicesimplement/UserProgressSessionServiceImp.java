package com.aecode.webcoursesback.servicesimplement;

import com.aecode.webcoursesback.entities.UserProgressSession;
import com.aecode.webcoursesback.repositories.IUserProgressSessionRepo;
import com.aecode.webcoursesback.services.IUserProgressSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProgressSessionServiceImp implements IUserProgressSessionService {

    @Autowired
    private IUserProgressSessionRepo upR;
    @Override
    public void insert(UserProgressSession userprogress) {
        upR.save(userprogress);
    }

    @Override
    public List<UserProgressSession> list() {
        return upR.findAll();
    }

    @Override
    public void delete(int progressId) {
        upR.deleteById(progressId);
    }

    @Override
    public UserProgressSession listId(int progressId) {
        return upR.findById(progressId).orElse(new UserProgressSession());
    }
}
