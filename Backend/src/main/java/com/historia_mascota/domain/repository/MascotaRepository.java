package com.historia_mascota.domain.repository;

import com.historia_mascota.domain.MascotaDomain;

import java.util.List;
import java.util.Optional;

public interface MascotaRepository {

    List<MascotaDomain> traerTodasMascotas();
    Optional<List<MascotaDomain>> traerMascotaPorNombre(String nombre);
    Optional<List<MascotaDomain>> traerMascotaPorRaza(String raza);
    Optional<List<MascotaDomain>> traerMascotaPorGenero(String genero);
    Optional<MascotaDomain> traerPorId(int idMascota);
    MascotaDomain guardarMascota(MascotaDomain mascotaDomain);
    void eliminarMascota(int idMascota);
}
