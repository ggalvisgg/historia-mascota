package com.historia_mascota.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="vet")
public class VetEntity {

    @Id
    @Column(name = "id_Vet")
    private int idVet;

    @Column(name = "nameVet")
    private String nameVet;

    @Column(name = "specialtyVet")
    private String specialtyVet;

    @Column(name = "phoneVet")
    private String phoneVet;

    @OneToMany(mappedBy = "vet")
    private List<SurgeryEntity> surgery;

    @OneToMany(mappedBy = "vet")
    private List<PetEntity> pet;

    @OneToMany(mappedBy = "vet")
    private List<DewormingEntity> deworming;

    @OneToMany(mappedBy = "vet")
    private List<WeightControlEntity> weight;
}
