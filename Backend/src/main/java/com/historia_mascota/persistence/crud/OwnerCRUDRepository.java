package com.historia_mascota.persistence.crud;

import com.historia_mascota.persistence.entity.OwnerEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface OwnerCRUDRepository extends CrudRepository<OwnerEntity, Integer> {

    @Override
    List<OwnerEntity> findAll();
    boolean existsByIdOwner(int idOwner);
    List<OwnerEntity> findByNameOwner(String nameOwner);
    List<OwnerEntity> findByAgeOwner(int ageOwner);
    Optional<OwnerEntity> findById(int idOwner);
}