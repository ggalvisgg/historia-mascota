package com.historia_mascota.persistence.crud;

import com.historia_mascota.persistence.entity.OwnerEntity;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<OwnerEntity, Long> {
}
