package com.historia_mascota.domain.dto;


import com.historia_mascota.persistence.entity.PetEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OwnerDto {

    private int id;
    private String name;
    private int age;
    private String phone;
    private List<PetDto> pet;
}
