package com.historia_mascota.persistence.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@MappedSuperclass
public class InformationTable {

    @Column(name = "dateControl")
    private LocalDate dateControl; //fecha

    @Column(name = "batchControl")
    private String batchControl; //lote

    @Column(name = "boosterControl")
    private LocalDate boosterControl; //refuerzo
}
