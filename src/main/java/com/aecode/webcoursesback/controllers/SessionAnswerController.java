package com.aecode.webcoursesback.controllers;
import com.aecode.webcoursesback.dtos.SessionAnswerDTO;
import com.aecode.webcoursesback.entities.SessionAnswer;
import com.aecode.webcoursesback.services.ISessionAnswerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sessionanswer")
public class SessionAnswerController {
    @Autowired
    private ISessionAnswerService aS;

    @PostMapping
    public ResponseEntity<String> insert(@RequestBody SessionAnswerDTO dto) {
        ModelMapper m = new ModelMapper();
        SessionAnswer s = m.map(dto, SessionAnswer.class);
        aS.insert(s);
        return ResponseEntity.status(201).body("created successfully");
    }

    @GetMapping
    public List<SessionAnswerDTO> list() {
        ModelMapper m = new ModelMapper();
        List<SessionAnswer> a = aS.list();
        return a.stream().map(answer -> {
            // Convertir la entidad a DTO y asignar el questionId manualmente
            SessionAnswerDTO dto = m.map(answer, SessionAnswerDTO.class);
            dto.setTestId(answer.getSessiontest().getTestId());  // Asignar manualmente el questionId
            return dto;
        }).collect(Collectors.toList());
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")Integer id){aS.delete(id);}

    @GetMapping("/{id}")
    public SessionAnswerDTO listId(@PathVariable("id")Integer id){
        ModelMapper m=new ModelMapper();
        SessionAnswerDTO dto=m.map(aS.listId(id), SessionAnswerDTO.class);
        return dto;
    }
    @PutMapping
    public void update(@RequestBody SessionAnswerDTO dto) {
        ModelMapper m = new ModelMapper();
        SessionAnswer a = m.map(dto, SessionAnswer.class);
        aS.insert(a);
    }

}
