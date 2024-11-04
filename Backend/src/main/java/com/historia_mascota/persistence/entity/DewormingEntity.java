package com.historia_mascota.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name="deworming")
public class DewormingEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDeworming;

    @Column(name = "dateDeworming")
    private String dateDeworming;

    @ManyToOne
    @JoinColumn(name = "idVet", insertable=false, updatable=false)
    private VetEntity vet;

    @ManyToOne
    @JoinColumn(name = "idTypeDeworming", insertable=false, updatable=false)
    private TypeDewormingEntity typeDeworming;

    @ManyToOne
    @JoinColumn(name = "idPet", insertable=false, updatable=false)
    private PetEntity pet;
}
