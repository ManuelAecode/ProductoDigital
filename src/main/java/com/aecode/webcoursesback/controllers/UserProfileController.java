package com.aecode.webcoursesback.controllers;

import com.aecode.webcoursesback.dtos.LoginDTO;
import com.aecode.webcoursesback.dtos.UserProfileDTO;
import com.aecode.webcoursesback.entities.UserProfile;
import com.aecode.webcoursesback.services.IUserProfileService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/userprofile")
public class UserProfileController {

    @Autowired
    private IUserProfileService upS;

    // Registro de un nuevo usuario
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserProfileDTO userProfileDTO) {
        try {
            upS.insert(userProfileDTO);
            return ResponseEntity.ok("Perfil creado exitosamente");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    // Autenticación de usuario existente
    @PostMapping("/login")
    public ResponseEntity<UserProfileDTO> login(@RequestBody LoginDTO dto) {
        UserProfile profile = upS.authenticateUser( dto);
        if (profile != null && profile.getPasswordHash().equals(dto.getPasswordHash())) {
            ModelMapper modelMapper = new ModelMapper(); // Crea una instancia de ModelMapper
            UserProfileDTO userProfileDTO = modelMapper.map(profile, UserProfileDTO.class); // Mapea de UserProfile a UserProfileDTO
            return ResponseEntity.ok(userProfileDTO); // Devuelve el objeto LoginDTO con el ID de perfil actualizado
        } else {
            return ResponseEntity.badRequest().body(null); // En caso de credenciales inválidas, puedes devolver null o un objeto vacío
        }
    }

    // Listado de todos los usuarios
    @GetMapping("/list")
    public List<UserProfileDTO> listUsers() {
        return upS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, UserProfileDTO.class);
        }).collect(Collectors.toList());
    }

    // Obtener un usuario por ID
    @GetMapping("/{id}")
    public UserProfileDTO listId(@PathVariable("id")Integer id) {
        ModelMapper m=new ModelMapper();
        UserProfileDTO dto=m.map(upS.listId(id),UserProfileDTO.class);
        return dto;
    }

    // Eliminar un usuario por ID
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")Integer id){upS.delete(id);}


    // Actualizar un usuario
    @PutMapping
    public void update(@RequestBody UserProfileDTO dto) {
        ModelMapper m = new ModelMapper();
        UserProfile p = m.map(dto, UserProfile.class);
        upS.update(p);
    }

}
