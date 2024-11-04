package com.historia_mascota.persistence.crud;

import com.historia_mascota.persistence.entity.DewormingEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface DewormingCRUDRepository extends CrudRepository<DewormingEntity, Integer> {

    @Override
    List<DewormingEntity> findAll();
    Optional<DewormingEntity> findById(int idDeworming);
}
