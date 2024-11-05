package com.historia_mascota.web.controller;

import com.historia_mascota.domain.CirujiaDomain;
import com.historia_mascota.domain.service.CirujiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/surgery")
public class SurgeryController {

    @Autowired
    private CirujiaService cirujiaService;

    @GetMapping("/all")
    public List<CirujiaDomain> getAll() {
        return cirujiaService.obtenerTodo();
    }

    @GetMapping("/{id}")
    public Optional<CirujiaDomain> getProduct(@PathVariable("id") int id) {
        return cirujiaService.obtenerPorId(id);
    }

    @PostMapping("/save")
    public CirujiaDomain save(@RequestBody CirujiaDomain cirujiaDomain) {
        return cirujiaService.guardarCirujia(cirujiaDomain);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") int id) {
        return cirujiaService.eliminarCirujia(id);
    }
}
