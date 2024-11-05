package com.historia_mascota.persistence.crud;

import com.historia_mascota.persistence.entity.TypeVaccineEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TypeVaccineCRUDRepository extends CrudRepository<TypeVaccineEntity, Integer> {

    @Override
    List<TypeVaccineEntity> findAll();
    Optional<TypeVaccineEntity> findById(int idTypeVaccine);
}
