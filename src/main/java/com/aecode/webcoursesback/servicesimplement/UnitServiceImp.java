package com.aecode.webcoursesback.servicesimplement;

import com.aecode.webcoursesback.entities.Unit;
import com.aecode.webcoursesback.repositories.IUnitRepo;
import com.aecode.webcoursesback.services.IUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitServiceImp implements IUnitService {

    @Autowired
    private IUnitRepo uR;

    @Override
    public void insert(Unit unit) {
        uR.save(unit);
    }

    @Override
    public List<Unit> list() {
        return uR.findAll();
    }

    @Override
    public void delete(int unitId) {
        uR.deleteById(unitId);
    }

    @Override
    public Unit listId(int unitId) {
        return uR.findById(unitId).orElse(new Unit());
    }
}
