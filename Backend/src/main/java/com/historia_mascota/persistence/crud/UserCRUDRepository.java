package com.historia_mascota.persistence.crud;

import com.historia_mascota.persistence.entity.OwnerEntity;
import com.historia_mascota.persistence.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserCRUDRepository extends CrudRepository<UserEntity, Integer> {
    Optional<UserEntity> findByIdUser(int idUser);
    List<UserEntity> findAll();
    boolean existsByIdUser(int idUser);
}
