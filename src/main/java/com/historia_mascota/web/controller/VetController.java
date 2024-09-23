package com.historia_mascota.web.controller;

import com.historia_mascota.domain.VeterinarioDomain;
import com.historia_mascota.domain.service.VeterinarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vets")
public class VetController {

    @Autowired
    private VeterinarioService veterinarioService;

    @GetMapping("/all")
    public List<VeterinarioDomain> getAll() {
        return veterinarioService.obtenerTodo();
    }

    @GetMapping("/{id}")
    public Optional<VeterinarioDomain> getProduct(@PathVariable("id") int id) {
        return veterinarioService.obtenerPorId(id);
    }

    @GetMapping("/nombre/{nombre}")
    public Optional<List<VeterinarioDomain>> getByName(@PathVariable("nombre") String name) {
        return veterinarioService.obtenerPorNombre(name);
    }

    @GetMapping("/especialidad/{especialidad}")
    public Optional<List<VeterinarioDomain>> getByEspecialidad(@PathVariable("especialidad") String especialidad) {
        return veterinarioService.obtenerPorEspecialidad(especialidad);
    }

    @PostMapping("/save")
    public VeterinarioDomain save(@RequestBody VeterinarioDomain veterinarioDomain) {
        return veterinarioService.guardarVeterinario(veterinarioDomain);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") int id) {
        return veterinarioService.eliminarVeterinario(id);
    }
}
