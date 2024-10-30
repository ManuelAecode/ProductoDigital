package com.aecode.webcoursesback.controllers;
import com.aecode.webcoursesback.dtos.RelatedWorkDTO;
import com.aecode.webcoursesback.entities.RelatedWork;
import com.aecode.webcoursesback.services.IRelatedWorkService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/relatedwork")
public class RelatedWorkController {
    @Autowired
    private IRelatedWorkService rwS;

    @PostMapping
    public ResponseEntity<String> insert(@RequestBody RelatedWorkDTO dto) {
        ModelMapper m = new ModelMapper();
        RelatedWork rw = m.map(dto, RelatedWork.class);
        rwS.insert(rw);
        return ResponseEntity.status(201).body("created successfully");
    }

    @GetMapping
    public List<RelatedWorkDTO> list() {
        return rwS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, RelatedWorkDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")Integer id){rwS.delete(id);}

    @GetMapping("/{id}")
    public RelatedWorkDTO listId(@PathVariable("id")Integer id){
        ModelMapper m=new ModelMapper();
        RelatedWorkDTO dto=m.map(rwS.listId(id),RelatedWorkDTO.class);
        return dto;
    }
    @PutMapping
    public void update(@RequestBody RelatedWorkDTO dto) {
        ModelMapper m = new ModelMapper();
        RelatedWork rw = m.map(dto, RelatedWork.class);
        rwS.insert(rw);
    }
}
