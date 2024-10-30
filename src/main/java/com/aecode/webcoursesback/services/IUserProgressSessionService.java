package com.aecode.webcoursesback.services;
import com.aecode.webcoursesback.entities.UserProgressSession;

import java.util.List;

public interface IUserProgressSessionService {

    public void insert(UserProgressSession userprogress);
    List<UserProgressSession> list();
    public void delete(int progressId);
    public UserProgressSession listId(int progressId);

}
