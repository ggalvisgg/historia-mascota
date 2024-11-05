package com.historia_mascota.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="surgery")
public class SurgeryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSurgery;

    @Column(name = "dateSurgery")
    private String dateSurgery;

    @Column(name = "hourSurgery")
    private String hourSurgery;

    @Column(name = "stateSurgery")
    private String stateSurgery;

    @Column(name = "observation")
    private String observation;

    @ManyToOne
    @JoinColumn(name = "idVet", nullable = false)
    private VetEntity vet;

    @ManyToOne
    @JoinColumn(name = "idPet", nullable = false)
    private PetEntity pet;

    @ManyToOne
    @JoinColumn(name = "idTypeSurgery", nullable = false)
    private TypeSurgeryEntity typeSurgery;

    public void setVet(VetEntity vet) {
        this.vet = vet;
    }

    public void setPet(PetEntity pet) {
        this.pet = pet;
    }

    public void setTypeSurgery(TypeSurgeryEntity typeSurgery) {
        this.typeSurgery = typeSurgery;
    }
}
