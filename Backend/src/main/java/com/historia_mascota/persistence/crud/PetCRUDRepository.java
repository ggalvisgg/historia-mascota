package com.historia_mascota.persistence.crud;

import com.historia_mascota.persistence.entity.PetEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PetCRUDRepository extends CrudRepository<PetEntity, Integer> {

    @Override
    List<PetEntity> findAll();
    List<PetEntity> findByNamePet(String namePet);
    List<PetEntity> findBySpeciesPet(String speciesPet);
    List<PetEntity> findByGenderPet(String genderPet);
    Optional<PetEntity> findById(int idPet);
}
