package com.aecode.webcoursesback.servicesimplement;

import com.aecode.webcoursesback.entities.UserCourseAccess;
import com.aecode.webcoursesback.repositories.IUserCourseRepo;
import com.aecode.webcoursesback.services.IUserCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCourseServiceImp implements IUserCourseService {
    @Autowired
    IUserCourseRepo ucR;

    @Override
    public void insert(UserCourseAccess usecourse) {
        ucR.save(usecourse);
    }

    @Override
    public List<UserCourseAccess> list() {
        return ucR.findAll();
    }

    @Override
    public void delete(int accessId) {
        ucR.deleteById(accessId);
    }

    @Override
    public UserCourseAccess listId(int accessId) {
        return ucR.findById(accessId).orElse(new UserCourseAccess());
    }
}
