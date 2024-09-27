package com.historia_mascota.persistence.crud;

import com.historia_mascota.persistence.entity.VetEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface VetCRUDRepository extends CrudRepository<VetEntity, Integer> {

    @Override
    List<VetEntity> findAll();
    List<VetEntity> findByNameVet(String nameVet);
    List<VetEntity> findBySpecialtyVet(String specialtyVet);
    Optional<VetEntity> findById(int idVet);
}
