package com.aecode.webcoursesback.controllers;
import com.aecode.webcoursesback.dtos.ModuleDTO;
import com.aecode.webcoursesback.dtos.RelatedWorkDTO;
import com.aecode.webcoursesback.dtos.SessionDTO;
import com.aecode.webcoursesback.dtos.UnitDTO;
import com.aecode.webcoursesback.entities.Module;
import com.aecode.webcoursesback.services.IModuleService;
import com.aecode.webcoursesback.services.ISessionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/module")
public class ModuleController {
    @Autowired
    private IModuleService mS;
    @Autowired
    private ISessionService cS;

    @PostMapping
    public ResponseEntity<String> insert(@RequestBody ModuleDTO dto) {
        ModelMapper m = new ModelMapper();
        Module module = m.map(dto, Module.class);
        mS.insert(module);
        return ResponseEntity.status(201).body("created successfully");
    }

    @GetMapping
    public List<ModuleDTO> list() {
        ModelMapper modelMapper = new ModelMapper();
        return mS.list().stream().map(module -> {
            ModuleDTO moduleDTO = modelMapper.map(module, ModuleDTO.class);

            // Mapeo de unidades y sus sesiones
            moduleDTO.setUnits(module.getUnits().stream().map(unit -> {
                UnitDTO unitDTO = modelMapper.map(unit, UnitDTO.class);

                // Mapeo de sesiones de la unidad
                unitDTO.setSessions(unit.getSessions().stream().map(session -> {
                    SessionDTO sessionDTO = modelMapper.map(session, SessionDTO.class);
                    // Establecer el contenido HTML
                    sessionDTO.setHtmlContent(cS.wrapInHtml(session.getDescription()));
                    return sessionDTO;
                }).collect(Collectors.toList()));

                return unitDTO;
            }).collect(Collectors.toList()));

            return moduleDTO;
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")Integer id){mS.delete(id);}

    @GetMapping("/{id}")
    public ModuleDTO listId(@PathVariable("id")Integer id){
        ModelMapper modelMapper = new ModelMapper();
        Module module = mS.listId(id);

        if (module == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Módulo no encontrado");
        }

        ModuleDTO dto = modelMapper.map(module, ModuleDTO.class);

        // Mapeo de unidades y sus sesiones
        dto.setUnits(module.getUnits().stream().map(unit -> {
            UnitDTO unitDTO = modelMapper.map(unit, UnitDTO.class);

            // Mapeo de sesiones de la unidad
            unitDTO.setSessions(unit.getSessions().stream().map(session -> {
                SessionDTO sessionDTO = modelMapper.map(session, SessionDTO.class);
                // Establecer el contenido HTML
                sessionDTO.setHtmlContent(cS.wrapInHtml(session.getDescription()));
                return sessionDTO;
            }).collect(Collectors.toList()));

            return unitDTO;
        }).collect(Collectors.toList()));

        return dto;
    }
    @PutMapping
    public void update(@RequestBody ModuleDTO dto) {
        ModelMapper m = new ModelMapper();
        Module module = m.map(dto, Module.class);
        mS.insert(module);
    }
}
