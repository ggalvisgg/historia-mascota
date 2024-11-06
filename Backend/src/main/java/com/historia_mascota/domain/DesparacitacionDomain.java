package com.historia_mascota.domain;

public class DesparacitacionDomain {

    private int id;
    private String fecha;
    private String tipoDesparacitacion;
    private String lote;
    private String refuerzo;
    private VeterinarioDomain veterinario;
    private TipoDesparacitacionDomain tipo;
    private MascotaDomain mascota;

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

    public String getTipoDesparacitacion() {
        return tipoDesparacitacion;
    }

    public void setTipoDesparacitacion(String tipoDesparacitacion) {
        this.tipoDesparacitacion = tipoDesparacitacion;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getRefuerzo() {
        return refuerzo;
    }

    public void setRefuerzo(String refuerzo) {
        this.refuerzo = refuerzo;
    }

    public VeterinarioDomain getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(VeterinarioDomain veterinario) {
        this.veterinario = veterinario;
    }

    public TipoDesparacitacionDomain getTipo() {
        return tipo;
    }

    public void setTipo(TipoDesparacitacionDomain tipo) {
        this.tipo = tipo;
    }

    public MascotaDomain getMascota() {
        return mascota;
    }

    public void setMascota(MascotaDomain mascota) {
        this.mascota = mascota;
    }
}

