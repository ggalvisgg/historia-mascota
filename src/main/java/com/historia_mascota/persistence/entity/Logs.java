package com.historia_mascota.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Logs {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private String typeAction;
    private LocalDate fecha;

    /*
    @ManyToOne
    @JoinColumn(name="idUser", insertable=false, updatable=false)
    private UserEntity user;

     */
}
