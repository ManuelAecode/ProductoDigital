package com.aecode.webcoursesback.controllers;
import com.aecode.webcoursesback.dtos.SessionDTO;
import com.aecode.webcoursesback.dtos.UnitDTO;
import com.aecode.webcoursesback.entities.Unit;
import com.aecode.webcoursesback.services.ISessionService;
import com.aecode.webcoursesback.services.IUnitService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/unit")
public class UnitController {
    @Autowired
    private IUnitService uS;
    @Autowired
    private ISessionService cS;

    @PostMapping
    public ResponseEntity<String> insert(@RequestBody UnitDTO dto) {
        ModelMapper m = new ModelMapper();
        Unit unit = m.map(dto, Unit.class);
        uS.insert(unit);
        return ResponseEntity.status(201).body("created successfully");
    }

    @GetMapping
    public List<UnitDTO> list() {
        return uS.list().stream().map(unit -> {
            ModelMapper modelMapper = new ModelMapper();
            UnitDTO unitDTO = modelMapper.map(unit, UnitDTO.class);

            // Mapear las sesiones a UnitDTO y establecer htmlContent
            unitDTO.setSessions(unit.getSessions().stream().map(session -> {
                SessionDTO sessionDTO = modelMapper.map(session, SessionDTO.class);
                sessionDTO.setHtmlContent(cS.wrapInHtml(session.getDescription())); // Establecer el contenido HTML
                return sessionDTO;
            }).collect(Collectors.toList()));

            return unitDTO;
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")Integer id){uS.delete(id);}

    @GetMapping("/{id}")
    public UnitDTO listId(@PathVariable("id")Integer id){
        Unit unit = uS.listId(id); // Obtener la unidad
        if (unit == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unidad no encontrada");
        }

        ModelMapper modelMapper = new ModelMapper();
        UnitDTO dto = modelMapper.map(unit, UnitDTO.class);

        // Mapear las sesiones a UnitDTO y establecer htmlContent
        dto.setSessions(unit.getSessions().stream().map(session -> {
            SessionDTO sessionDTO = modelMapper.map(session, SessionDTO.class);
            sessionDTO.setHtmlContent(cS.wrapInHtml(session.getDescription())); // Establecer el contenido HTML
            return sessionDTO;
        }).collect(Collectors.toList()));

        return dto;
    }
    @PutMapping
    public void update(@RequestBody UnitDTO dto) {
        ModelMapper m = new ModelMapper();
        Unit unit = m.map(dto, Unit.class);
        uS.insert(unit);
    }
}
