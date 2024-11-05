package com.historia_mascota.domain;

public class CirujiaDomain {

    private int id;
    private String fecha;
    private String hora;
    private String estado;
    private String observacion;
    private VeterinarioDomain veterinario;
    private MascotaDomain mascota;
    private TipoCirujiaDomain tipo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public VeterinarioDomain getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(VeterinarioDomain veterinario) {
        this.veterinario = veterinario;
    }

    public MascotaDomain getMascota() {
        return mascota;
    }

    public void setMascota(MascotaDomain mascota) {
        this.mascota = mascota;
    }

    public TipoCirujiaDomain getTipo() {
        return tipo;
    }

    public void setTipo(TipoCirujiaDomain tipo) {
        this.tipo = tipo;
    }
}
