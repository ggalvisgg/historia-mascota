package com.historia_mascota.persistence.entity;

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

    public List<PetEntity> getPet() {
        return pet;
    }

    public void setPet(List<PetEntity> pet) {
        this.pet = pet;
    }

    public int getIdVet() {
        return idVet;
    }

    public void setIdVet(int idVet) {
        this.idVet = idVet;
    }

    public List<DewormingEntity> getDeworming() {
        return deworming;
    }

    public void setDeworming(List<DewormingEntity> deworming) {
        this.deworming = deworming;
    }

    public List<SurgeryEntity> getSurgery() {
        return surgery;
    }

    public void setSurgery(List<SurgeryEntity> surgery) {
        this.surgery = surgery;
    }

    public String getNameVet() {
        return nameVet;
    }

    public void setNameVet(String nameVet) {
        this.nameVet = nameVet;
    }

    public String getPhoneVet() {
        return phoneVet;
    }

    public void setPhoneVet(String phoneVet) {
        this.phoneVet = phoneVet;
    }

    public String getSpecialtyVet() {
        return specialtyVet;
    }

    public void setSpecialtyVet(String specialtyVet) {
        this.specialtyVet = specialtyVet;
    }

    public List<WeightControlEntity> getWeight() {
        return weight;
    }

    public void setWeight(List<WeightControlEntity> weight) {
        this.weight = weight;
    }
}
