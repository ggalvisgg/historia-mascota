package com.historia_mascota.domain.repository;

import com.historia_mascota.domain.DuenioDomain;

import java.util.List;
import java.util.Optional;

public interface DuenioRepository {

    //Asi es la estructura dada por el profesor, cambia el OwnerDomaindd

    List<DuenioDomain> findAll();
    Optional<List<DuenioDomain>> findByNameOwner(String nameOwner);
    Optional<List<DuenioDomain>> findByAgeOwner(int ageOwner);
    Optional<DuenioDomain> findById(int idOwner);
    DuenioDomain save(DuenioDomain ownerDomain);
    void delete(int idOwner);
}


