package com.historia_mascota.persistence.crud;

import com.historia_mascota.persistence.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserCRUDRepository extends CrudRepository<UserEntity, Integer> {
}
