package com.historia_mascota.web.controller;

import com.historia_mascota.domain.TipoDesparacitacionDomain;
import com.historia_mascota.domain.service.TipoDesparacitacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/types")
public class TypeDewormingController {

    @Autowired
    private TipoDesparacitacionService tipoDesparacitacionService;

    @GetMapping("/all")
    public List<TipoDesparacitacionDomain> getAll() {
        return tipoDesparacitacionService.obtenerTodo();
    }

    @GetMapping("/{id}")
    public Optional<TipoDesparacitacionDomain> getProduct(@PathVariable("id") int id) {
        return tipoDesparacitacionService.obtenerPorId(id);
    }

    @PostMapping("/save")
    public TipoDesparacitacionDomain save(@RequestBody TipoDesparacitacionDomain tipoDesparacitacionDomain) {
        return tipoDesparacitacionService.guardarTipoDesparacitacion(tipoDesparacitacionDomain);
    }
}
