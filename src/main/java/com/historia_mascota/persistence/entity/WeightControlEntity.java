package com.historia_mascota.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "weightControl")
public class WeightControlEntity extends InformationTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idWeightControl;

    @Column(name="dateWeight")
    private LocalDate dateWeight;

    @Column(name = "weight")
    private float weight;

    @ManyToOne
    @JoinColumn(name = "codVet", insertable=false, updatable=false)
    private VetEntity vet;

    @ManyToOne
    @JoinColumn(name="idPet", insertable=false, updatable=false)
    private PetEntity pet;
}
