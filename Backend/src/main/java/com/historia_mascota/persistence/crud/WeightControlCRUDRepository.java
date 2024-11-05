package com.historia_mascota.persistence.crud;

import com.historia_mascota.persistence.entity.WeightControlEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface WeightControlCRUDRepository extends CrudRepository<WeightControlEntity, Integer> {

    @Override
    List<WeightControlEntity> findAll();
    Optional<WeightControlEntity> findById(int idWeightControl);
}
