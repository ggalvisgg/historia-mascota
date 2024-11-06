package com.historia_mascota.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="deworming")
public class DewormingEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDeworming;

    @Column(name = "dateDeworming")
    private String dateDeworming;

    @Column(name = "type")
    private String type;

    @Column(name = "batchControl")
    private String batchControl; //lote

    @Column(name = "boosterControl")
    private String boosterControl; //refuerzo

    @ManyToOne
    @JoinColumn(name = "idVet", nullable = false)
    private VetEntity vet;

    @ManyToOne
    @JoinColumn(name = "idTypeDeworming", nullable = false)
    private TypeDewormingEntity typeDeworming;

    @ManyToOne
    @JoinColumn(name = "idPet", nullable = false)
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
