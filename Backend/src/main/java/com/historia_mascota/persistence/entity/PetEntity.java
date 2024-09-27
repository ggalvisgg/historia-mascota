package com.historia_mascota.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "pet")
public class PetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPet;

    @Column(name = "namePet")
    private String namePet;

    @Column(name = "typePet")
    private String typePet;

    @Column(name = "speciesPet")
    private String speciesPet;

    @Column(name = "agePet")
    private int agePet;

    @Column(name = "genderPet")
    private String genderPet;

    @ManyToOne
    @JoinColumn(name = "idOwner")
    private OwnerEntity owner;

    @ManyToOne
    @JoinColumn(name = "idVet")
    private VetEntity vet;

    @OneToMany(mappedBy = "pet")
    private List<VacunationEntity> vacunation;

    @OneToMany(mappedBy = "pet")
    private List<WeightControlEntity> weight;

    @OneToMany(mappedBy = "pet")
    private List<DewormingEntity> deworming;

    @OneToMany(mappedBy = "pet")
    private List<SurgeryEntity> surgery;

    @OneToMany(mappedBy = "pet")
    private List<NotificationEntity> notification;

    @Override
    public String toString() {
        return "PetEntity{id=" + idPet + ", name='" + namePet + '\'' + '}';
    }

    public void setVet(VetEntity vet) {
        this.vet = vet;
    }

    public void setOwner(OwnerEntity owner) {
        this.owner = owner;
    }

    public void setWeight(List<WeightControlEntity> weight) {
        this.weight = weight;
    }

    public void setDeworming(List<DewormingEntity> deworming) {
        this.deworming = deworming;
    }

    public void setSurgery(List<SurgeryEntity> surgery) {
        this.surgery = surgery;
    }

    public void setAgePet(int agePet) {
        this.agePet = agePet;
    }

    public void setIdPet(int idPet) {
        this.idPet = idPet;
    }

    public void setGenderPet(String genderPet) {
        this.genderPet = genderPet;
    }

    public void setNamePet(String namePet) {
        this.namePet = namePet;
    }

    public void setNotification(List<NotificationEntity> notification) {
        this.notification = notification;
    }

    public void setSpeciesPet(String speciesPet) {
        this.speciesPet = speciesPet;
    }

    public void setTypePet(String typePet) {
        this.typePet = typePet;
    }

    public void setVacunation(List<VacunationEntity> vacunation) {
        this.vacunation = vacunation;
    }

    public List<WeightControlEntity> getWeight() {
        return weight;
    }

    public List<SurgeryEntity> getSurgery() {
        return surgery;
    }

    public List<DewormingEntity> getDeworming() {
        return deworming;
    }

    public int getIdPet() {
        return idPet;
    }

    public int getAgePet() {
        return agePet;
    }

    public List<NotificationEntity> getNotification() {
        return notification;
    }

    public List<VacunationEntity> getVacunation() {
        return vacunation;
    }

    public OwnerEntity getOwner() {
        return owner;
    }

    public String getGenderPet() {
        return genderPet;
    }

    public String getNamePet() {
        return namePet;
    }

    public String getSpeciesPet() {
        return speciesPet;
    }

    public String getTypePet() {
        return typePet;
    }

    public VetEntity getVet() {
        return vet;
    }
}