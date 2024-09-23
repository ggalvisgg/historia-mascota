package com.historia_mascota.domain.repository;

import com.historia_mascota.domain.VeterinarioDomain;

import java.util.List;
import java.util.Optional;

public interface VeterinarioRepository {

    List<VeterinarioDomain> traerTodosVeterinarios();
    boolean existeVet(int id);
    Optional<List<VeterinarioDomain>> traerPorNombre(String nombre);
    Optional<List<VeterinarioDomain>> traerPorEspecialidad(String especialidad);
    Optional<VeterinarioDomain> traerPorIdentificacion(int id);
    VeterinarioDomain guardarVeterinario(VeterinarioDomain veterinarioDomain);
    void eliminarVeterinario(int id);
}
