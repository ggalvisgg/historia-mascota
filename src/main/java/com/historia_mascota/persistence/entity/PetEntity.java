package com.historia_mascota.persistence.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="pet")
public class PetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPet;
    @Column(name = "namePet")
    private String namePet;

    @Column(name = "speciesPet")
    private String speciesPet;

    @Column(name = "agePet")
    private int agePet;

    @Column(name = "genderPet")
    private String genderPet;

    @ManyToOne
    @JoinColumn(name = "idOwner", insertable=false, updatable=false)
    private OwnerEntity owner;

    @OneToMany(mappedBy = "pet")
    private List<SurgeryEntity> surgery;
}
