package com.historia_mascota.persistence.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="pet")
public class PetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPet;

    @Column(name = "namePet")
    private String namePet;

    @Column(name = "speciesPet")
    private String speciesPet;

    @Column(name = "agePet")
    private int agePet;

    @Column(name = "genderPet")
    private String genderPet;
}
