package com.historia_mascota.persistence.entity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

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

    @OneToMany(mappedBy = "vaccine")
    private List<TypeVaccineEntity> typeVaccine;
}
