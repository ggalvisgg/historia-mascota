package com.historia_mascota.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "owner")
public class OwnerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Owner")
    private int idOwner;

    @Column(name = "nameOwner")
    private String nameOwner;

    @Column(name = "lastOwner")
    private String lastOwner;

    @Column(name = "ageOwner")
    private int ageOwner;

    @Column(name = "phoneOwner")
    private String phoneOwner;

    @OneToMany(mappedBy = "owner")
    private List<PetEntity> pet;

    @Override
    public String toString() {
        return "OwnerEntity{id=" + idOwner + ", name='" + nameOwner + '\'' + '}';
    }

    public int getIdOwner() {
        return idOwner;
    }

    public int getAgeOwner() {
        return ageOwner;
    }

    public String getLastOwner() {
        return lastOwner;
    }

    public String getNameOwner() {
        return nameOwner;
    }

    public String getPhoneOwner() {
        return phoneOwner;
    }

    public void setIdOwner(int idOwner) {
        this.idOwner = idOwner;
    }

    public void setAgeOwner(int ageOwner) {
        this.ageOwner = ageOwner;
    }

    public void setLastOwner(String lastOwner) {
        this.lastOwner = lastOwner;
    }

    public void setNameOwner(String nameOwner) {
        this.nameOwner = nameOwner;
    }

    public List<PetEntity> getPet() {
        return pet;
    }

    public void setPhoneOwner(String phoneOwner) {
        this.phoneOwner = phoneOwner;
    }

    public void setPet(List<PetEntity> pet) {
        this.pet = pet;
    }
}