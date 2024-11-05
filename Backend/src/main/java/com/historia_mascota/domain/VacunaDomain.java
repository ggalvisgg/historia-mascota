package com.historia_mascota.domain;

public class VacunaDomain {

    private int id;
    private String nombreVacuna;
    private String descripcionVacuna;
    private String productorVacuna;
    private String fechaExpiracion;
    private int cantidad;
    private TipoVacunaDomain tipo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreVacuna() {
        return nombreVacuna;
    }

    public void setNombreVacuna(String nombreVacuna) {
        this.nombreVacuna = nombreVacuna;
    }

    public String getDescripcionVacuna() {
        return descripcionVacuna;
    }

    public void setDescripcionVacuna(String descripcionVacuna) {
        this.descripcionVacuna = descripcionVacuna;
    }

    public String getProductorVacuna() {
        return productorVacuna;
    }

    public void setProductorVacuna(String productorVacuna) {
        this.productorVacuna = productorVacuna;
    }

    public String getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(String fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public TipoVacunaDomain getTipo() {
        return tipo;
    }

    public void setTipo(TipoVacunaDomain tipo) {
        this.tipo = tipo;
    }
}
