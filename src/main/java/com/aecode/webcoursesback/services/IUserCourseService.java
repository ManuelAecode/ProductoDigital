package com.aecode.webcoursesback.services;

import com.aecode.webcoursesback.entities.UserCourseAccess;

import java.util.List;

public interface IUserCourseService {

    public void insert(UserCourseAccess usecourse);
    List<UserCourseAccess> list();
    public void delete(int accessId);
    public UserCourseAccess listId(int accessId);
}
