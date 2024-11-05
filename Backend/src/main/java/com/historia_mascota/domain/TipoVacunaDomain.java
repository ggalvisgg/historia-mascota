package com.historia_mascota.domain;

import java.util.List;

public class TipoVacunaDomain {

    private int id;
    private String descripcion;
    private List<VacunaDomain> vacuna;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<VacunaDomain> getVacuna() {
        return vacuna;
    }

    public void setVacuna(List<VacunaDomain> vacuna) {
        this.vacuna = vacuna;
    }
}
