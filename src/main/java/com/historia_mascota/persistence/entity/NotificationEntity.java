package com.historia_mascota.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name="notification")
public class NotificationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codNotification;

    @Column(name = "message")
    private String message;

    @Column(name = "dateSent")
    private LocalDate dateSent;

    @ManyToOne
    @JoinColumn(name = "codPet", insertable=false, updatable=false)
    private PetEntity pet;
}
