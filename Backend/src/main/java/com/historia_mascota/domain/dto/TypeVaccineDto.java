package com.historia_mascota.domain.dto;

import com.historia_mascota.persistence.entity.VaccineEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TypeVaccineDto {

    private int idTypeVaccine;
    private String name;
    private String descriptionVaccine;
    private String cantVaccine;
    private VaccineDto vaccine;
}
