package com.historia_mascota.domain;

import java.util.List;

public class TipoCirujiaDomain {

    private int id;
    private String descripcion;
    private List<CirujiaDomain> cirujia;

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

    public List<CirujiaDomain> getCirujia() {
        return cirujia;
    }

    public void setCirujia(List<CirujiaDomain> cirujia) {
        this.cirujia = cirujia;
    }
}
