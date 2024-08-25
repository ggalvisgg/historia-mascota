package com.historia_mascota.persistence.crud;

import com.historia_mascota.persistence.entity.PetEntity;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<PetEntity, Integer> {



}
