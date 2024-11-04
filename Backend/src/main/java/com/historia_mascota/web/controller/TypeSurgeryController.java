package com.historia_mascota.web.controller;

import com.historia_mascota.domain.TipoCirujiaDomain;
import com.historia_mascota.domain.service.TipoCirujiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/typesSu")
public class TypeSurgeryController {

    @Autowired
    private TipoCirujiaService tipoCirujiaService;

    @GetMapping("/all")
    public List<TipoCirujiaDomain> getAll() {
        return tipoCirujiaService.obtenerTodo();
    }

    @GetMapping("/{id}")
    public Optional<TipoCirujiaDomain> getProduct(@PathVariable("id") int id) {
        return tipoCirujiaService.obtenerPorId(id);
    }

    @PostMapping("/save")
    public TipoCirujiaDomain save(@RequestBody TipoCirujiaDomain tipoCirujiaDomain) {
        return tipoCirujiaService.guardarTipoCirujia(tipoCirujiaDomain);
    }
}
