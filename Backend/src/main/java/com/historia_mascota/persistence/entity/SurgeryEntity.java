package com.historia_mascota.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="surgery")
public class SurgeryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSurgery;

    @Column(name = "dateSurgery")
    private String dateSurgery;

    @Column(name = "hourSurgery")
    private String hourSurgery;

    @Column(name = "stateSurgery")
    private String stateSurgery;

    @Column(name = "observation")
    private String observation;

    @ManyToOne
    @JoinColumn(name = "idVet")
    private VetEntity vet;

    @ManyToOne
    @JoinColumn(name = "idPet")
    private PetEntity pet;

    @ManyToOne
    @JoinColumn(name = "idTypeSurgery")
    private TypeSurgeryEntity typeSurgery;
}
