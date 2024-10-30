package com.aecode.webcoursesback.controllers;
import com.aecode.webcoursesback.dtos.UnitDTO;
import com.aecode.webcoursesback.entities.Unit;
import com.aecode.webcoursesback.services.IUnitService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/unit")
public class UnitController {
    @Autowired
    private IUnitService uS;

    @PostMapping
    public ResponseEntity<String> insert(@RequestBody UnitDTO dto) {
        ModelMapper m = new ModelMapper();
        Unit unit = m.map(dto, Unit.class);
        uS.insert(unit);
        return ResponseEntity.status(201).body("created successfully");
    }

    @GetMapping
    public List<UnitDTO> list() {
        return uS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, UnitDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")Integer id){uS.delete(id);}

    @GetMapping("/{id}")
    public UnitDTO listId(@PathVariable("id")Integer id){
        ModelMapper m=new ModelMapper();
        UnitDTO dto=m.map(uS.listId(id),UnitDTO.class);
        return dto;
    }
    @PutMapping
    public void update(@RequestBody UnitDTO dto) {
        ModelMapper m = new ModelMapper();
        Unit unit = m.map(dto, Unit.class);
        uS.insert(unit);
    }
}
