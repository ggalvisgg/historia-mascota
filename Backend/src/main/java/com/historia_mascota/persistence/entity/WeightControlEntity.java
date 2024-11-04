package com.historia_mascota.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "weightControl")
public class WeightControlEntity extends InformationTable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idWeightControl;

    @Column(name="dateWeight")
    private String dateWeight;

    @Column(name = "weight")
    private float weight;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idVet", nullable = false)
    private VetEntity vet;

    @ManyToOne(optional = false)
    @JoinColumn(name="idPet", nullable = false)
    private PetEntity pet;

}
