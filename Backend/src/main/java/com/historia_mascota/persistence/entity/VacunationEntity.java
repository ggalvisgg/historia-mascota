package com.historia_mascota.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name ="vacunation")
public class VacunationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVacunation;

    @Column(name = "dateVaccine")
    private String dateVaccine;

    @Column(name = "batchControl")
    private String batchControl; //lote

    @Column(name = "boosterControl")
    private String boosterControl; //refuerzo

    @ManyToOne
    @JoinColumn(name = "idVet", nullable = false)
    private VetEntity vet;

    @ManyToOne
    @JoinColumn(name = "idPet", nullable = false)
    private PetEntity pet;

    @ManyToOne
    @JoinColumn(name = "idVaccine", nullable = false)
    private VaccineEntity vaccine;

    //espera
    @ManyToOne
    @JoinColumn(name = "idPeriodicity", nullable = false)
    private PeriodicityEntity periodicity;
}
