package com.historia_mascota.domain;

public class VacunacionDomain {

    private int id;
    private String fecha;
    private String loteVacuna;
    private String refuerzoVacuna;
    private VeterinarioDomain veterinario;
    private MascotaDomain mascota;
    private VacunaDomain vacuna;
    private PeriodicidadDomain periodicidad;

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

    public String getLoteVacuna() {
        return loteVacuna;
    }

    public void setLoteVacuna(String loteVacuna) {
        this.loteVacuna = loteVacuna;
    }

    public String getRefuerzoVacuna() {
        return refuerzoVacuna;
    }

    public void setRefuerzoVacuna(String refuerzoVacuna) {
        this.refuerzoVacuna = refuerzoVacuna;
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

    public VacunaDomain getVacuna() {
        return vacuna;
    }

    public void setVacuna(VacunaDomain vacuna) {
        this.vacuna = vacuna;
    }

    public PeriodicidadDomain getPeriodicidad() {
        return periodicidad;
    }

    public void setPeriodicidad(PeriodicidadDomain periodicidad) {
        this.periodicidad = periodicidad;
    }
}
