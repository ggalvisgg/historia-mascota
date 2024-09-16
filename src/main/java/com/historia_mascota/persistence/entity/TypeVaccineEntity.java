package com.historia_mascota.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="type-vaccine")
public class TypeVaccineEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTypeVaccine;

    @Column(name = "descriptionVaccine")
    private String descriptionVaccine;

    @OneToMany(mappedBy = "typeVaccine")
    private List<VaccineEntity> vaccines;
}
