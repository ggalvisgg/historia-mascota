package com.historia_mascota.domain.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VetDto {

    private int idVet;
    private String nameVet;
    private String specialtyVet;
}
