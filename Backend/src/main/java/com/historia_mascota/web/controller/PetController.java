package com.historia_mascota.web.controller;

import com.historia_mascota.domain.DuenioDomain;
import com.historia_mascota.domain.MascotaDomain;
import com.historia_mascota.domain.service.DuenioService;
import com.historia_mascota.domain.service.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private MascotaService mascotaService;

    @Autowired
    private DuenioService duenioService;

    @GetMapping("/all")
    public List<MascotaDomain> getAll() {
        return mascotaService.obtenerTodo();
    }

    @GetMapping("/{id}")
    public Optional<MascotaDomain> getProduct(@PathVariable("id") int idMascota) {
        return mascotaService.obtenerPorId(idMascota);
    }

    @GetMapping("/nombre/{nombre}")
    public Optional<List<MascotaDomain>> getByName(@PathVariable("nombre") String nombre) {
        return mascotaService.obtenerPorNombre(nombre);
    }

    @GetMapping("/genero/{genero}")
    public Optional<List<MascotaDomain>> getByGender(@PathVariable("genero") String genero) {
        return mascotaService.obtenerPorGenero(genero);
    }

    @GetMapping("/raza/{raza}")
    public Optional<List<MascotaDomain>> getBySpecies(@PathVariable("raza") String raza) {
        return mascotaService.obtenerPorRaza(raza);
    }

    @PostMapping("/save")
    public MascotaDomain save(@RequestBody MascotaDomain mascotaDomain) {
        return mascotaService.guardarMascota(mascotaDomain);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") int idMascota) {
        return mascotaService.eliminarMascota(idMascota);
    }
}


