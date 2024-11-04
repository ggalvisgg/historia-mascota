package com.historia_mascota.persistence.crud;

import com.historia_mascota.persistence.entity.TypeDewormingEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TypeDewormingCRUDRepository extends CrudRepository<TypeDewormingEntity, Integer> {

    @Override
    List<TypeDewormingEntity> findAll();
    Optional<TypeDewormingEntity> findById(int idTypeDeworming);
}
