package com.aecode.webcoursesback.controllers;

import com.aecode.webcoursesback.dtos.SessionDTO;
import com.aecode.webcoursesback.entities.Session;
import com.aecode.webcoursesback.services.ISessionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/session")
public class SessionController {
    @Value("${file.upload-dir}")
    private String uploadDir;

    @Autowired
    private ISessionService cS;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> insert(@RequestPart(value="file", required = false) MultipartFile imagen,
                                         @RequestPart(value = "data", required = false) String dtoJson) {
        String originalFilename = null;
        try {

            ObjectMapper objectMapper = new ObjectMapper();
            SessionDTO dto= objectMapper.readValue(dtoJson, SessionDTO.class);

            String userUploadDir = uploadDir + File.separator + "session";
            Path userUploadPath = Paths.get(userUploadDir);
            if (!Files.exists(userUploadPath)) {
                Files.createDirectories(userUploadPath);
            }

            // Manejo del archivo de script
            if (imagen != null && !imagen.isEmpty()) {
                originalFilename = imagen.getOriginalFilename();;
                byte[] bytes = imagen.getBytes();
                Path path = userUploadPath.resolve(originalFilename);
                Files.write(path, bytes);
            }

            // Convertir DTO a entidad
            ModelMapper modelMapper = new ModelMapper();
            Session classes = modelMapper.map(dto, Session.class);
            // Establecer la ruta del archivo en la entidad
            classes.setResourceDocument("/uploads/session/" +originalFilename);
            cS.insert(classes);

            return ResponseEntity.ok("Sesión guardado correctamente");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al guardar el archivo de imagen: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al insertar el objeto en la base de datos: " + e.getMessage());
        }
    }


    @GetMapping("/search")
    public List<SessionDTO> searchByTitle(@RequestParam("title") String title) {
        return cS.findByTitle(title).stream().map(session -> {
            ModelMapper m = new ModelMapper();
            SessionDTO dto = m.map(session, SessionDTO.class);
            dto.setHtmlContent(cS.wrapInHtml(session.getDescription()));
            return dto;
        }).collect(Collectors.toList());
    }

    @GetMapping
    public List<SessionDTO> list() {
        return cS.list().stream().map(session -> {
            ModelMapper m = new ModelMapper();
            SessionDTO dto = m.map(session, SessionDTO.class);
            dto.setHtmlContent(cS.wrapInHtml(session.getDescription()));
            return dto;
        }).collect(Collectors.toList());
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")Integer id){cS.delete(id);}

    @GetMapping("/{id}")
    public SessionDTO listId(@PathVariable("id")Integer id){
        ModelMapper m=new ModelMapper();
        Session session = cS.listId(id);
        if (session == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Sesión no encontrada");
        }
        SessionDTO dto = m.map(session, SessionDTO.class);
        dto.setHtmlContent(cS.wrapInHtml(session.getDescription())); // aqui se añade el HTML formateado
        return dto;
    }
    @PutMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> update(@RequestPart(value="file", required = false) MultipartFile document,
                                         @RequestPart(value = "data", required = false) String dtoJson) {
        String originalFilename = null;
        try {
            // Convertir el JSON a SessionDTO
            ObjectMapper objectMapper = new ObjectMapper();
            SessionDTO dto = objectMapper.readValue(dtoJson, SessionDTO.class);

            // Obtener la clase existente desde la base de datos
            Session existingSession = cS.listId(dto.getSessionId());
            if (existingSession == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Clase no encontrada");
            }

            String userUploadDir = uploadDir + File.separator + "class";
            Path userUploadPath = Paths.get(userUploadDir);
            if (!Files.exists(userUploadPath)) {
                Files.createDirectories(userUploadPath);
            }

            // Manejo del archivo de documento
            if (document != null && !document.isEmpty()) {
                // Si se sube un nuevo documento, reemplazar el documento actual
                originalFilename = document.getOriginalFilename();
                byte[] bytes = document.getBytes();
                Path path = userUploadPath.resolve(originalFilename);
                Files.write(path, bytes);

                // Actualizar la ruta del documento en la entidad
                existingSession.setResourceDocument("class/" + originalFilename);
            }

            // Actualizar otros datos de la clase
            ModelMapper modelMapper = new ModelMapper();
            modelMapper.map(dto, existingSession);  // Mapear solo los cambios del DTO a la clase existente

            // Guardar los cambios en la base de datos
            cS.insert(existingSession);

            return ResponseEntity.ok("Clase actualizada correctamente");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al guardar el archivo de documento: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar la clase: " + e.getMessage());
        }
    }



}
