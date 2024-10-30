package com.aecode.webcoursesback.controllers;
import com.aecode.webcoursesback.dtos.CourseDTO;
import com.aecode.webcoursesback.entities.Session;
import com.aecode.webcoursesback.entities.Course;
import com.aecode.webcoursesback.services.ICourseService;import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/course")
public class CourseController  {

    @Value("${file.upload-dir}")
    private String uploadDir;
    @Autowired
    private ICourseService cS;

    @PostMapping
    public ResponseEntity<String> insert(@RequestBody CourseDTO dto) {
        ModelMapper m = new ModelMapper();
        Course c = m.map(dto, Course.class);
        cS.insert(c);
        return ResponseEntity.status(201).body("created successfully");
    }

    @GetMapping
    public List<CourseDTO> list() {
        return cS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, CourseDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")Integer id){cS.delete(id);}

    @GetMapping("/{id}")
    public CourseDTO listId(@PathVariable("id")Integer id){
        ModelMapper m=new ModelMapper();
        CourseDTO dto=m.map(cS.listId(id),CourseDTO.class);
        return dto;
    }
    @PutMapping
    public void update(@RequestBody CourseDTO dto) {
        ModelMapper m = new ModelMapper();
        Course c = m.map(dto, Course.class);
        cS.insert(c);
    }
}
