package com.aecode.webcoursesback.controllers;
import com.aecode.webcoursesback.dtos.ModuleDTO;
import com.aecode.webcoursesback.dtos.RelatedWorkDTO;
import com.aecode.webcoursesback.dtos.SessionDTO;
import com.aecode.webcoursesback.entities.Module;
import com.aecode.webcoursesback.services.IModuleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/module")
public class ModuleController {
    @Autowired
    private IModuleService mS;

    @PostMapping
    public ResponseEntity<String> insert(@RequestBody ModuleDTO dto) {
        ModelMapper m = new ModelMapper();
        Module module = m.map(dto, Module.class);
        mS.insert(module);
        return ResponseEntity.status(201).body("created successfully");
    }

    @GetMapping
    public List<ModuleDTO> list() {
        return mS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ModuleDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")Integer id){mS.delete(id);}

    @GetMapping("/{id}")
    public ModuleDTO listId(@PathVariable("id")Integer id){
        ModelMapper m=new ModelMapper();
        ModuleDTO dto=m.map(mS.listId(id),ModuleDTO.class);
        return dto;
    }
    @PutMapping
    public void update(@RequestBody ModuleDTO dto) {
        ModelMapper m = new ModelMapper();
        Module module = m.map(dto, Module.class);
        mS.insert(module);
    }
}
