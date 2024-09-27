package com.historia_mascota.persistence.entity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="vaccine")
public class VaccineEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codVaccine;

    @Column(name = "nameVaccine")
    private String nameVaccine;

    @Column(name = "descriptionVaccine")
    private String descriptionVaccine;

    @Column(name = "producerVaccine")
    private String producerVaccine;

    @Column(name = "expirationDate")
    private String expirationDate;

    @Column(name = "cantVaccine")
    private String cantVaccine;

    @ManyToOne
    @JoinColumn(name="idTypeVaccine", insertable=false, updatable=false)
    private TypeVaccineEntity typeVaccine;
}
