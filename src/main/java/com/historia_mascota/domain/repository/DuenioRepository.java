package com.historia_mascota.domain.repository;

import com.historia_mascota.domain.DuenioDomain;

import java.util.List;
import java.util.Optional;

public interface DuenioRepository {

    //Asi es la estructura dada por el profesor, cambia el OwnerDomain

    List<DuenioDomain> getAll();
    Optional<List<DuenioDomain>> getByName(String nameOwner);
    Optional<List<DuenioDomain>> getByAge(int ageOwner);
    Optional<DuenioDomain> getOwner(int idOwner);
    DuenioDomain save(DuenioDomain ownerDomain);
    void delete(int idOwner);

}


