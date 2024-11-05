package com.historia_mascota.persistence.entity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="vaccine")
public class VaccineEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVaccine;

    @Column(name = "nameVaccine")
    private String nameVaccine;

    @Column(name = "descriptionVaccine")
    private String descriptionVaccine;

    @Column(name = "producerVaccine")
    private String producerVaccine;

    @Column(name = "expirationDate")
    private String expirationDate;

    @Column(name = "cantVaccine")
    private int cantVaccine;

    @ManyToOne
    @JoinColumn(name="idTypeVaccine", nullable = false)
    private TypeVaccineEntity typeVaccine;

    public void setTypeVaccine(TypeVaccineEntity typeVaccine) {
        this.typeVaccine = typeVaccine;
    }
}
