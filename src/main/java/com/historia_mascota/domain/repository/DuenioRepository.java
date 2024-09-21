package com.historia_mascota.domain.repository;

import com.historia_mascota.domain.DuenioDomain;
import com.historia_mascota.domain.UsuarioDomain;

import java.util.List;
import java.util.Optional;

public interface DuenioRepository {

    //Asi es la estructura dada por el profesor, cambia el OwnerDomainddjds

    List<DuenioDomain> traerTodosDuenios();
    Optional<List<DuenioDomain>> traerPorNombre(String nameOwner);
    Optional<List<DuenioDomain>> traerPorEdad(int ageOwner);
    Optional<DuenioDomain> traerPorIdentificacion(int idOwner);
    DuenioDomain guardarDuenio(DuenioDomain ownerDomain);
    void eliminarDuenio(int idOwner);

}


