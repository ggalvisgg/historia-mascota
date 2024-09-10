package com.historia_mascota.persistence.crud;

import com.historia_mascota.persistence.entity.OwnerEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OwnerCRUDRepository extends CrudRepository<OwnerEntity, Long> {

    /*List<OwnerEntity> findByNameOwner(String nameOwner);
    List<OwnerEntity> findByPhoneOwner(String phoneOwner);
    List<OwnerEntity> findByAgeOwnerGreaterThanEqual(int ageOwner);
    List<OwnerEntity> findByAgeOwnerBetween(int startAge, int endAge);

    @Query(value = "SELECT * FROM owner WHERE name_owner = :nameOwner", nativeQuery = true)
    List<OwnerEntity> findOwnersByNameNative(String nameOwner);
    @Query(value = "SELECT * FROM owner WHERE phone_owner = :phoneOwner", nativeQuery = true)
    List<OwnerEntity> findOwnersByPhoneNative(String phoneOwner);
    */

}
