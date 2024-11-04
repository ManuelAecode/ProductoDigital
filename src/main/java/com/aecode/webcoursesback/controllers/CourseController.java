package com.aecode.webcoursesback.controllers;
import com.aecode.webcoursesback.dtos.CourseDTO;
import com.aecode.webcoursesback.dtos.ModuleDTO;
import com.aecode.webcoursesback.dtos.SessionDTO;
import com.aecode.webcoursesback.dtos.UnitDTO;
import com.aecode.webcoursesback.entities.Session;
import com.aecode.webcoursesback.entities.Course;
import com.aecode.webcoursesback.services.ICourseService;
import com.aecode.webcoursesback.services.ISessionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/course")
public class CourseController  {

    @Value("${file.upload-dir}")
    private String uploadDir;
    @Autowired
    private ICourseService cS;

    @Autowired
    private ISessionService sS;

    @PostMapping
    public ResponseEntity<String> insert(@RequestBody CourseDTO dto) {
        ModelMapper m = new ModelMapper();
        Course c = m.map(dto, Course.class);
        cS.insert(c);
        return ResponseEntity.status(201).body("created successfully");
    }

    @GetMapping
    public List<CourseDTO> list() {
        ModelMapper modelMapper = new ModelMapper();
        return cS.list().stream().map(course -> {
            CourseDTO courseDTO = modelMapper.map(course, CourseDTO.class);

            // Mapeo de módulos y sus unidades y sesiones
            courseDTO.setModules(course.getModules().stream().map(module -> {
                ModuleDTO moduleDTO = modelMapper.map(module, ModuleDTO.class);

                // Mapeo de unidades
                moduleDTO.setUnits(module.getUnits().stream().map(unit -> {
                    UnitDTO unitDTO = modelMapper.map(unit, UnitDTO.class);

                    // Mapeo de sesiones de la unidad
                    unitDTO.setSessions(unit.getSessions().stream().map(session -> {
                        SessionDTO sessionDTO = modelMapper.map(session, SessionDTO.class);
                        // Establecer el contenido HTML
                        sessionDTO.setHtmlContent(sS.wrapInHtml(session.getDescription()));
                        return sessionDTO;
                    }).collect(Collectors.toList()));

                    return unitDTO;
                }).collect(Collectors.toList()));

                return moduleDTO;
            }).collect(Collectors.toList()));

            return courseDTO;
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")Integer id){cS.delete(id);}

    @GetMapping("/{id}")
    public CourseDTO listId(@PathVariable("id")Integer id){
        ModelMapper modelMapper = new ModelMapper();
        Course course = cS.listId(id);

        if (course == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso no encontrado");
        }

        CourseDTO dto = modelMapper.map(course, CourseDTO.class);

        // Mapeo de módulos y sus unidades y sesiones
        dto.setModules(course.getModules().stream().map(module -> {
            ModuleDTO moduleDTO = modelMapper.map(module, ModuleDTO.class);

            // Mapeo de unidades
            moduleDTO.setUnits(module.getUnits().stream().map(unit -> {
                UnitDTO unitDTO = modelMapper.map(unit, UnitDTO.class);

                // Mapeo de sesiones de la unidad
                unitDTO.setSessions(unit.getSessions().stream().map(session -> {
                    SessionDTO sessionDTO = modelMapper.map(session, SessionDTO.class);
                    // Establecer el contenido HTML
                    sessionDTO.setHtmlContent(sS.wrapInHtml(session.getDescription()));
                    return sessionDTO;
                }).collect(Collectors.toList()));

                return unitDTO;
            }).collect(Collectors.toList()));

            return moduleDTO;
        }).collect(Collectors.toList()));

        return dto;
    }
    @PutMapping
    public void update(@RequestBody CourseDTO dto) {
        ModelMapper m = new ModelMapper();
        Course c = m.map(dto, Course.class);
        cS.insert(c);
    }
}
