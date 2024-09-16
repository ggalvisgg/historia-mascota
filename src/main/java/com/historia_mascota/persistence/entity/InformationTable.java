package com.historia_mascota.persistence.entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class InformationTable {

    private LocalDate dateControl; //fecha
    private String batchControl; //lote
    private LocalDate boosterControl; //refuerzo

}
