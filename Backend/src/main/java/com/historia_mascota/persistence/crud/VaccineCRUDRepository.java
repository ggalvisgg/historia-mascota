package com.historia_mascota.persistence.crud;

import com.historia_mascota.persistence.entity.VaccineEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface VaccineCRUDRepository extends CrudRepository<VaccineEntity, Integer> {

    @Override
    List<VaccineEntity> findAll();
    Optional<VaccineEntity> findById(int idVaccine);
}
