package com.historia_mascota.persistence.crud;

import com.historia_mascota.persistence.entity.SurgeryEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface SurgeryCRUDRepositoy extends CrudRepository<SurgeryEntity, Integer> {

    @Override
    List<SurgeryEntity> findAll();
    Optional<SurgeryEntity> findById(int idSurgery);
}
