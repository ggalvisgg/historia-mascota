package com.historia_mascota.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="type-deworming")
public class TypeDewormingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTypeDeworming;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "type-deworming")
    private List<DewormingEntity> typeDeworming;
}
