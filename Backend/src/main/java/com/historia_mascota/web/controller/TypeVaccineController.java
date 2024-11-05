package com.historia_mascota.web.controller;

import com.historia_mascota.domain.TipoVacunaDomain;
import com.historia_mascota.domain.service.TipoVacunaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/typesVa")
public class TypeVaccineController {

    @Autowired
    private TipoVacunaService tipoVacunaService;

    @GetMapping("/all")
    public List<TipoVacunaDomain> getAll() {
        return tipoVacunaService.obtenerTodo();
    }

    @GetMapping("/{id}")
    public Optional<TipoVacunaDomain> getProduct(@PathVariable("id") int id) {
        return tipoVacunaService.obtenerPorId(id);
    }

    @PostMapping("/save")
    public TipoVacunaDomain save(@RequestBody TipoVacunaDomain tipoVacunaDomain) {
        return tipoVacunaService.guardarTipoVacuna(tipoVacunaDomain);
    }

    /*
    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") int idTypeVaccine) {
        return tipoVacunaService.(idMascota);
    }

     */
}
