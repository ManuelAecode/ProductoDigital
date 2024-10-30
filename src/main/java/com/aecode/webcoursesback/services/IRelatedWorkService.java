package com.aecode.webcoursesback.services;
import com.aecode.webcoursesback.entities.RelatedWork;

import java.util.List;

public interface IRelatedWorkService {
    public void insert(RelatedWork work);
    List<RelatedWork> list();
    public void delete(int workId);
    public RelatedWork listId(int workId);
}
