package com.historia_mascota.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name="deworming")
public class DewormingEntity extends InformationTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDeworming;

    @Column(name = "dateDeworming")
    private LocalDate dateDeworming;

    @ManyToOne
    @JoinColumn(name = "codVet", insertable=false, updatable=false)
    private VetEntity vet;

    @ManyToOne
    @JoinColumn(name = "idDeworming", insertable=false, updatable=false)
    private TypeDewormingEntity typeDeworming;

    @ManyToOne
    @JoinColumn(name = "idPet", insertable=false, updatable=false)
    private PetEntity pet;
}
