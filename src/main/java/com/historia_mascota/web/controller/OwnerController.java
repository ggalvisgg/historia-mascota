package com.historia_mascota.web.controller;

import com.historia_mascota.domain.DuenioDomain;
import com.historia_mascota.domain.service.DuenioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/owners")
public class OwnerController {

    @Autowired
    private DuenioService duenioService;

    @GetMapping("/all")
    public List<DuenioDomain> getAll() {
        return duenioService.obtenerTodo();
    }

    @GetMapping("/{id}")
    public Optional<DuenioDomain> getProduct(@PathVariable("id") int id) {
        return duenioService.obtenerPorId(id);
    }

    @GetMapping("/name/{name}")
    public Optional<List<DuenioDomain>> getByName(@PathVariable("name") String name) {
        return duenioService.obtenerPorNombre(name);
    }

    @PostMapping("/save")
    public DuenioDomain save(@RequestBody DuenioDomain duenioDomain) {
        return duenioService.guardarDuenio(duenioDomain);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") int id) {
        return duenioService.eliminarDuenio(id);
    }
    
}




