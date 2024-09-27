package com.historia_mascota.domain.service;

import com.historia_mascota.domain.MascotaDomain;
import com.historia_mascota.domain.repository.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MascotaService {

    @Autowired
    private MascotaRepository mascotaRepository;

    public List<MascotaDomain> obtenerTodo() {
        return mascotaRepository.traerTodasMascotas();
    }

    public Optional<MascotaDomain> obtenerPorId(int idMascota) {
        return mascotaRepository.traerPorId(idMascota);
    }

    public Optional<List<MascotaDomain>> obtenerPorNombre(String nombre) {
        return mascotaRepository.traerMascotaPorNombre(nombre);
    }

    public Optional<List<MascotaDomain>> obtenerPorGenero(String genero) {
        return mascotaRepository.traerMascotaPorGenero(genero);
    }

    public Optional<List<MascotaDomain>> obtenerPorRaza(String raza) {
        return mascotaRepository.traerMascotaPorRaza(raza);
    }

    public MascotaDomain guardarMascota(MascotaDomain mascotaDomain) {
        return mascotaRepository.guardarMascota(mascotaDomain);
    }

    public boolean eliminarMascota(int idMascota) {
        return obtenerPorId(idMascota).map(product -> {
            mascotaRepository.eliminarMascota(idMascota);
            return true;
        }).orElse(false);
    }
}
