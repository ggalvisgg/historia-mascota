package com.historia_mascota.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="privaccination")
public class PrivaccinationEntity extends InformationTable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPrivaccination;

    @Column(name = "datePrivaccination")
    private String datePrivaccination;

    @ManyToOne
    @JoinColumn(name = "codVaccine", insertable=false, updatable=false)
    private VaccineEntity vaccine;

    @ManyToOne
    @JoinColumn(name = "codVet", insertable=false, updatable=false)
    private VetEntity vet;

    @ManyToOne
    @JoinColumn(name = "codPet", insertable=false, updatable=false)
    private PetEntity pet;
}
