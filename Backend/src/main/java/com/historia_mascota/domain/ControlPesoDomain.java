package com.historia_mascota.domain;

public class ControlPesoDomain {

    private int id;
    private String fechaControl;
    private String horaControl;
    private float peso;
    private VeterinarioDomain veterinario;
    private MascotaDomain mascota;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFechaControl() {
        return fechaControl;
    }

    public void setFechaControl(String fechaControl) {
        this.fechaControl = fechaControl;
    }

    public String getHoraControl() {
        return horaControl;
    }

    public void setHoraControl(String horaControl) {
        this.horaControl = horaControl;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public MascotaDomain getMascota() {
        return mascota;
    }

    public void setMascota(MascotaDomain mascota) {
        this.mascota = mascota;
    }

    public VeterinarioDomain getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(VeterinarioDomain veterinario) {
        this.veterinario = veterinario;
    }
}
