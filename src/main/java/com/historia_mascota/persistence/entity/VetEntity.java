package com.historia_mascota.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="vet")
public class VetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVet;

    @Column(name = "nameVet")
    private String nameVet;

    @Column(name = "specialtyVet")
    private String specialtyVet;

    @Column(name = "phoneVet")
    private String phoneVet;

    @ManyToOne
    @JoinColumn(name = "idUser", insertable=false, updatable=false)
    private UserEntity user;

    @OneToMany(mappedBy = "vet")
    private List<SurgeryEntity> surgery;

    @OneToMany(mappedBy = "vet")
    private List<PetEntity> pet;

    @OneToMany(mappedBy = "vet")
    private List<DewormingEntity> deworming;

    @OneToMany(mappedBy = "vet")
    private List<WeightControlEntity> weight;
}
