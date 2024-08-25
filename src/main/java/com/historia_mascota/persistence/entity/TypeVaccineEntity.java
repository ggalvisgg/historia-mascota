package com.historia_mascota.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="type-vaccine")
public class TypeVaccineEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTypeVaccine;

    @Column(name = "name")
    private String name;

    @Column(name = "descriptionVaccine")
    private String descriptionVaccine;

    @Column(name = "cantVaccine")
    private String cantVaccine;

    @ManyToOne
    @JoinColumn(name = "codVaccine", insertable=false, updatable=false)
    private VaccineEntity vaccine;
}
