package com.historia_mascota.persistence.crud;

import com.historia_mascota.persistence.entity.OwnerEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface OwnerCRUDRepository extends CrudRepository<OwnerEntity, Integer> {

    // Devuelve todos los propietarios
    List<OwnerEntity> getAll();

    List<OwnerEntity> getByName(String nameOwner);

    // Devuelve los propietarios por edad
    List<OwnerEntity> getByAge(int ageOwner);

    // Busca un propietario por su ID

    Optional<OwnerEntity> getOwner(int idOwner);



    /*
    // Devuelve los propietarios por nombre
    Optional<List<OwnerEntity>> getByName(String nameOwner);

    // Devuelve los propietarios por edad
    Optional<List<OwnerEntity>> getByAge(int ageOwner);

    // Busca un propietario por su ID
    Optional<OwnerEntity> getOwner(int idOwner);

     */
}