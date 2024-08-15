package com.historia_mascota.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="owner")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOwner;

    @Column(name = "nameOwner")
    private String nameOwner;

    @Column(name = "ageOwner")
    private int ageOwner;

    @Column(name = "phoneOwner")
    private String phoneOwner;
}
