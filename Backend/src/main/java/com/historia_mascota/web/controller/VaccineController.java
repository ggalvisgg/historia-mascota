package com.historia_mascota.web.controller;

import com.historia_mascota.domain.VacunaDomain;
import com.historia_mascota.domain.service.VacunaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vaccine")
public class VaccineController {

    @Autowired
    private VacunaService vacunaService;

    @GetMapping("/all")
    public List<VacunaDomain> getAll() {
        return vacunaService.obtenerTodo();
    }

    @GetMapping("/{id}")
    public Optional<VacunaDomain> getProduct(@PathVariable("id") int id) {
        return vacunaService.obtenerPorId(id);
    }

    @PostMapping("/save")
    public VacunaDomain save(@RequestBody VacunaDomain vacunaDomain) {
        return vacunaService.guardarVacuna(vacunaDomain);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") int id) {
        return vacunaService.eliminarVacuna(id);
    }
}
