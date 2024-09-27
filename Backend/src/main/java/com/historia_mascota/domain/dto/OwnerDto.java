package com.historia_mascota.domain.dto;


import com.historia_mascota.domain.MascotaDomain;
import com.historia_mascota.domain.UsuarioDomain;
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
    private String last;
    private int age;
    private String phone;
    private List<MascotaDomain> pets;

    // Constructores, getters y setters

}
