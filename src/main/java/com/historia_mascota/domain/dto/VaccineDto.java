package com.historia_mascota.domain.dto;

import com.historia_mascota.persistence.entity.TypeVaccineEntity;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class VaccineDto {

    private int codVaccine;
    private String DateVaccine;
    private List<TypeVaccineEntity> typeVaccine;
}
