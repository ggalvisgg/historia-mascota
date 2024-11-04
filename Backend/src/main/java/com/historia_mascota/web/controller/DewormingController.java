package com.historia_mascota.web.controller;

import com.historia_mascota.domain.DesparacitacionDomain;
import com.historia_mascota.domain.service.DesparacitacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/deworming")
public class DewormingController {

    @Autowired
    private DesparacitacionService desparacitacionService;

    @GetMapping("/all")
    public List<DesparacitacionDomain> getAll() {
        return desparacitacionService.obtenerTodo();
    }

    @GetMapping("/{id}")
    public Optional<DesparacitacionDomain> getProduct(@PathVariable("id") int id) {
        return desparacitacionService.obtenerPorId(id);
    }

    @PostMapping("/save")
    public DesparacitacionDomain save(@RequestBody DesparacitacionDomain desparacitacionDomain) {
        return desparacitacionService.guardarDesparacitacion(desparacitacionDomain);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") int id) {
        return desparacitacionService.eliminarDesparacitacion(id);
    }
}
