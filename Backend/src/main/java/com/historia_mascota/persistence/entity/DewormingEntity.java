package com.historia_mascota.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name="deworming")
public class DewormingEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDeworming;

    @Column(name = "dateDeworming")
    private String dateDeworming;

    @ManyToOne
    @JoinColumn(name = "idVet")
    private VetEntity vet;

    @ManyToOne
    @JoinColumn(name = "idTypeDeworming")
    private TypeDewormingEntity typeDeworming;

    @ManyToOne
    @JoinColumn(name = "idPet")
    private PetEntity pet;

    public VetEntity getVet() {
        return vet;
    }

    public PetEntity getPet() {
        return pet;
    }

    public TypeDewormingEntity getTypeDeworming() {
        return typeDeworming;
    }

    public void setVet(VetEntity vet) {
        this.vet = vet;
    }

    public void setTypeDeworming(TypeDewormingEntity typeDeworming) {
        this.typeDeworming = typeDeworming;
    }

    public void setPet(PetEntity pet) {
        this.pet = pet;
    }
}
