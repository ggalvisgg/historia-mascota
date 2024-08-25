package com.historia_mascota.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name="surgery")
public class SurgeryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codSurgery;

    @Column(name = "dateSurgery")
    private LocalDate dateSurgery;

    @Column(name = "description")
    private String description;

    @Column(name = "stateSurgery")
    private String stateSurgery;

    @Column(name = "observation")
    private String observation;

    //vet

    @ManyToOne
    @JoinColumn(name = "idPet", insertable=false, updatable=false)
    private PetEntity pet;
}
