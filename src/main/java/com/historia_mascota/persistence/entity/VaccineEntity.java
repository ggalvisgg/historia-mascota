package com.historia_mascota.persistence.entity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="vaccine")
public class VaccineEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codVaccine;

    @Column(name = "DateVaccine")
    private String DateVaccine;

    //animal
    //typeVaccine
}
