package com.historia_mascota.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;

    @OneToMany(mappedBy = "user")
    private List<VetEntity> vet;

    @OneToMany(mappedBy = "user")
    private List<OwnerEntity> owner;

    @OneToMany(mappedBy = "user")
    private List<Logs> logs;
}
