package com.historia_mascota.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="periodicity")
public class PeriodicityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPeriodicity;

    @Column(name="description")
    private String description;

    @Column(name="intervalDays")
    private int intervalDays;

    @OneToMany(mappedBy = "periodicity")
    private List<PetEntity> pet;
}
