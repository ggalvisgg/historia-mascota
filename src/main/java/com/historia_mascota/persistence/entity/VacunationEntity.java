package com.historia_mascota.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name ="vacunation")
public class VacunationEntity extends InformationTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVacunation;

    @Column(name = "dateVaccine")
    private LocalDate dateVaccine;

    @ManyToOne
    @JoinColumn(name = "codVet", insertable=false, updatable=false)
    private VetEntity vet;

    @ManyToOne
    @JoinColumn(name = "idPet", insertable=false, updatable=false)
    private PetEntity pet;

    @ManyToOne
    @JoinColumn(name = "codVaccine", insertable=false, updatable=false)
    private VaccineEntity vaccine;
}
