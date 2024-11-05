package com.historia_mascota.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "weightControl")
public class WeightControlEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idWeightControl;

    @Column(name="dateWeight")
    private String dateWeight;

    @Column(name="hourWeight")
    private String hourWeight;

    @Column(name = "weight")
    private float weight;

    @ManyToOne
    @JoinColumn(name = "idVet", nullable = false)
    private VetEntity vet;

    @ManyToOne
    @JoinColumn(name="idPet", nullable = false)
    private PetEntity pet;

    public void setPet(PetEntity pet) {
        this.pet = pet;
    }

    public void setVet(VetEntity vet) {
        this.vet = vet;
    }
}
