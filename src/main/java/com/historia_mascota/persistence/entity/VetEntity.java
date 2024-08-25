package com.historia_mascota.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="vet")
public class VetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVet;

    @Column(name = "nameVet")
    private String nameVet;

    @Column(name = "specialtyVet")
    private String specialtyVet;
}
