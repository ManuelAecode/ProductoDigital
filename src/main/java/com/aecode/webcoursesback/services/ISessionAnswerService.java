package com.aecode.webcoursesback.services;
import com.aecode.webcoursesback.entities.SessionAnswer;

import java.util.List;

public interface ISessionAnswerService {
    public void insert(SessionAnswer answer);
    List<SessionAnswer> list();
    public void delete(int answerId);
    public SessionAnswer listId(int answerId);
}
