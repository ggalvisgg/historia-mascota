package com.historia_mascota.domain.dto;


import com.historia_mascota.persistence.entity.OwnerEntity;
import com.historia_mascota.persistence.entity.SurgeryEntity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PetDto {

    private int idPet;
    private String namePet;
    private String speciesPet;
    private int agePet;
    private String genderPet;
    private OwnerEntity owner;
    private List<SurgeryEntity> surgery;
}
