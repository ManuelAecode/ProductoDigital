package com.aecode.webcoursesback.services;
import com.aecode.webcoursesback.entities.Unit;

import java.util.List;

public interface IUnitService {
    public void insert(Unit unit);
    List<Unit> list();
    public void delete(int unitId);
    public Unit listId(int unitId);
}
