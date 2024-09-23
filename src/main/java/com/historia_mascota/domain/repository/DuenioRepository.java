package com.historia_mascota.domain.repository;

import com.historia_mascota.domain.DuenioDomain;

import java.util.List;
import java.util.Optional;

public interface DuenioRepository {

    List<DuenioDomain> traerTodosDuenios();
    boolean existeDuenio(int idOwner);
    Optional<List<DuenioDomain>> traerPorNombre(String nameOwner);
    Optional<List<DuenioDomain>> traerPorEdad(int ageOwner);
    Optional<DuenioDomain> traerPorIdentificacion(int idOwner);
    DuenioDomain guardarDuenio(DuenioDomain ownerDomain);
    void eliminarDuenio(int idOwner);
}


