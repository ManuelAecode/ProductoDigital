package com.aecode.webcoursesback.controllers;
import com.aecode.webcoursesback.dtos.UserCourseDTO;
import com.aecode.webcoursesback.entities.*;
import com.aecode.webcoursesback.services.ICourseService;
import com.aecode.webcoursesback.services.IUserCourseService;
import com.aecode.webcoursesback.services.IUserProfileService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usercourse")
public class UserCourseController {
    @Autowired
    IUserCourseService ucS;
    @Autowired
    private IUserProfileService pS;
    @Autowired
    private ICourseService cS;

    @PostMapping
    public ResponseEntity<String> insert(@RequestBody UserCourseDTO dto) {
        ModelMapper m = new ModelMapper();

        // Cargar manualmente las entidades UserProfile y Session
        UserProfile user = pS.listId(dto.getUserId());
        Course course = cS.listId(dto.getCourseId());

        if (user == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuario no encontrado");
        }
        if (course == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Curso no encontrado");
        }

        // Mapear el DTO a la entidad
        UserCourseAccess usercourse = new UserCourseAccess();
        usercourse.setUserProfile(user); // Asignar el UserProfile
        usercourse.setCourse(course);   // Asignar la Session

        // Guardar en la base de datos
        ucS.insert(usercourse);

        return ResponseEntity.ok("Curso del usuario guardado correctamente");
    }

    @GetMapping
    public List<UserCourseDTO> list() {
        return ucS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, UserCourseDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")Integer id){ucS.delete(id);}

    @GetMapping("/{id}")
    public UserCourseDTO listId(@PathVariable("id")Integer id){
        ModelMapper m=new ModelMapper();
        UserCourseDTO dto=m.map(ucS.listId(id),UserCourseDTO.class);
        return dto;
    }
    @PutMapping
    public void update(@RequestBody UserCourseDTO dto) {
        ModelMapper m = new ModelMapper();
        UserCourseAccess uca = m.map(dto, UserCourseAccess.class);
        // Asegurarse de cargar los objetos UserProfile y Session
        UserProfile user = pS.listId(dto.getUserId());
        Course course = cS.listId(dto.getCourseId());

        uca.setUserProfile(user);
        uca.setCourse(course);

        ucS.insert(uca);
    }
}
