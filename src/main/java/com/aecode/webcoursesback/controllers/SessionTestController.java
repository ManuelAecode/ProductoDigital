package com.aecode.webcoursesback.controllers;
import com.aecode.webcoursesback.dtos.SessionTestDTO;
import com.aecode.webcoursesback.entities.SessionTest;
import com.aecode.webcoursesback.services.ISessionTestService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sessiontest")
public class SessionTestController {

    @Autowired
    private ISessionTestService qS;


    @PostMapping
    public ResponseEntity<String> insert(@RequestBody SessionTestDTO dto) {
        ModelMapper m = new ModelMapper();
        SessionTest s = m.map(dto, SessionTest.class);
        qS.insert(s);
        return ResponseEntity.status(201).body("created successfully");

    }

    @GetMapping
    public List<SessionTestDTO> list() {
        return qS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, SessionTestDTO.class);
        }).collect(Collectors.toList());
    }

        @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")Integer id){qS.delete(id);}

    @GetMapping("/{id}")
    public SessionTestDTO listId(@PathVariable("id")Integer id){
        ModelMapper m=new ModelMapper();
        SessionTestDTO dto=m.map(qS.listId(id), SessionTestDTO.class);
        return dto;
    }
    @PutMapping
    public void update(@RequestBody SessionTestDTO dto) {
        ModelMapper m = new ModelMapper();
        SessionTest q = m.map(dto, SessionTest.class);
        qS.insert(q);
    }
}
