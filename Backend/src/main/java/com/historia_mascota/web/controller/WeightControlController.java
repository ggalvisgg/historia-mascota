package com.historia_mascota.web.controller;

import com.historia_mascota.domain.ControlPesoDomain;
import com.historia_mascota.domain.service.ControlPesoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/weight")
public class WeightControlController {

    @Autowired
    private ControlPesoService controlPesoService;

    @GetMapping("/all")
    public List<ControlPesoDomain> getAll() {
        return controlPesoService.obtenerTodo();
    }

    @GetMapping("/{id}")
    public Optional<ControlPesoDomain> getProduct(@PathVariable("id") int id) {
        return controlPesoService.obtenerPorId(id);
    }

    @PostMapping("/save")
    public ControlPesoDomain save(@RequestBody ControlPesoDomain controlPesoDomain) {
        return controlPesoService.guardarControlPeso(controlPesoDomain);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") int id) {
        return controlPesoService.eliminarControlPeso(id);
    }
}
