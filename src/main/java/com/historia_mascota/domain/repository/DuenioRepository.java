package com.historia_mascota.domain.repository;

import com.historia_mascota.domain.DuenioDomain;

import java.util.List;
import java.util.Optional;

public interface DuenioRepository {

    //Asi es la estructura dada por el profesor, cambia el OwnerDomain

    List<DuenioDomain> getAll();  // Devuelve todos los propietarios
    Optional<List<DuenioDomain>> getByName(String nameOwner);  // Devuelve los propietarios por nombre
    Optional<List<DuenioDomain>> getByAge(int ageOwner);  // Devuelve los propietarios por edad
    Optional<DuenioDomain> getOwner(int idOwner);  // Busca un propietario por su ID
    DuenioDomain save(DuenioDomain ownerDomain);  // Guarda o actualiza un propietario
    void delete(int idOwner);  // Elimina un propietario por su ID
}


