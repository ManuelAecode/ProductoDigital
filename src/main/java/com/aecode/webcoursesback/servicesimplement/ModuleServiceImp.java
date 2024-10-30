package com.aecode.webcoursesback.servicesimplement;

import com.aecode.webcoursesback.entities.Module;
import com.aecode.webcoursesback.repositories.IModuleRepo;
import com.aecode.webcoursesback.services.IModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuleServiceImp implements IModuleService {

    @Autowired
    private IModuleRepo mR;

    @Override
    public void insert(Module module) {
        mR.save(module);
    }

    @Override
    public List<Module> list() {
        return mR.findAll();
    }

    @Override
    public void delete(int moduleId) {
        mR.deleteById(moduleId);
    }

    @Override
    public Module listId(int moduleId) {
        return mR.findById(moduleId).orElse(new Module());
    }
}
