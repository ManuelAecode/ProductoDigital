package com.aecode.webcoursesback.services;

import com.aecode.webcoursesback.entities.Module;

import java.util.List;

public interface IModuleService {
    public void insert(Module module);
    List<Module> list();
    public void delete(int moduleId);
    public Module listId(int moduleId);
}
