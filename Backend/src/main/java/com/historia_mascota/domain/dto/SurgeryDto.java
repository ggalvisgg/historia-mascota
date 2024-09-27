package com.historia_mascota.domain.dto;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class SurgeryDto {

    private int codSurgery;
    private LocalDate dateSurgery;
    private String description;
    private String stateSurgery;
    private String observation;
    private PetDto pet;
}

