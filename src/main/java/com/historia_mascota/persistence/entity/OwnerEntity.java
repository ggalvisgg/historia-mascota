package com.historia_mascota.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="owner")
public class OwnerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOwner;

    @Column(name = "nameOwner")
    private String nameOwner;

    @Column(name = "lastOwner")
    private String lastOwner;

    @Column(name = "ageOwner")
    private int ageOwner;

    @Column(name = "phoneOwner")
    private String phoneOwner;

    @OneToMany(mappedBy = "owner")
    private List<PetEntity> pet;

}
