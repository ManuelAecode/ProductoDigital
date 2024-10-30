package com.aecode.webcoursesback.servicesimplement;

import com.aecode.webcoursesback.entities.RelatedWork;
import com.aecode.webcoursesback.repositories.IRelatedWorkRepo;
import com.aecode.webcoursesback.services.IRelatedWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelatedWorkImp implements IRelatedWorkService {
    @Autowired
    private IRelatedWorkRepo rwR;

    @Override
    public void insert(RelatedWork work) {
        rwR.save(work);
    }

    @Override
    public List<RelatedWork> list() {
        return rwR.findAll();
    }

    @Override
    public void delete(int workId) {
        rwR.deleteById(workId);
    }

    @Override
    public RelatedWork listId(int workId) {
        return rwR.findById(workId).orElse(new RelatedWork());
    }
}
