package com.historia_mascota.persistence.crud;

import com.historia_mascota.persistence.entity.TypeSurgeryEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TypeSurgeryCRUDRepository extends CrudRepository<TypeSurgeryEntity, Integer> {

    @Override
    List<TypeSurgeryEntity> findAll();
    Optional<TypeSurgeryEntity> findById(int idTypeSurgery);
}
