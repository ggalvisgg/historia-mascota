package com.historia_mascota.domain.dto;


import com.historia_mascota.persistence.entity.PetEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OwnerDto {

    private int idOwner;
    private String nameOwner;
    private int ageOwner;
    private String phoneOwner;
    private List<PetDto> pet;
}
