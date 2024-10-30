package com.aecode.webcoursesback.services;


import com.aecode.webcoursesback.entities.SessionTest;

import java.util.List;

public interface ISessionTestService {
    public void insert(SessionTest question);
    List<SessionTest> list();
    public void delete(int questionId);
    public SessionTest listId(int questionId);
}
