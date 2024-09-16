package com.historia_mascota.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="type-surgery")
public class TypeSurgeryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codTypeSurgery;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "typeSurgery")
    private List<SurgeryEntity> surgery;
}
