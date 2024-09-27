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

    @Column(name = "nameSurgery")
    private String nameSurgery;

    @Column(name = "description")
    private String description;

    @Column(name = "dateSurgery")
    private LocalDate dateSurgery;

    @Column(name = "stateSurgery")
    private boolean stateSurgery;

    @Column(name = "observation")
    private String observation;

    @ManyToOne
    @JoinColumn(name = "idVet", insertable=false, updatable=false)
    private VetEntity vet;

    @ManyToOne
    @JoinColumn(name = "idPet", insertable=false, updatable=false)
    private PetEntity pet;

    @ManyToOne
    @JoinColumn(name = "idTypeSurgery", insertable=false, updatable=false)
    private TypeSurgeryEntity typeSurgery;
}
