package com.historia_mascota.web.controller;

import com.historia_mascota.domain.UsuarioDomain;
import com.historia_mascota.domain.service.UsuarioService;
import com.historia_mascota.persistence.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/all")
    public List<UserEntity> getAll() {
        return usuarioService.obtenerTodo();
    }
}
