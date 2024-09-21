package com.historia_mascota.domain;

import java.util.List;

public class MascotaDomain {

    private int id;
    private String nombre;
    private String tipoMascota;
    private String raza;
    private int edad;
    private String genero;
    private DuenioDomain duenioId;
    private VeterinarioDomain veterinarioId;
    private List<VacunacionDomain> vacunacion;
    private List<ControlPesoDomain> controlPeso;
    private List<DesparacitacionDomain> desparacitacion;
    private List<CirujiaDomain> cirujia;
    private List<NotificacionDomain> notificacion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoMascota() {
        return tipoMascota;
    }

    public void setTipoMascota(String tipoMascota) {
        this.tipoMascota = tipoMascota;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public DuenioDomain getDuenioId() {
        return duenioId;
    }

    public void setDuenioId(DuenioDomain duenioId) {
        this.duenioId = duenioId;
    }

    public VeterinarioDomain getVeterinarioId() {
        return veterinarioId;
    }

    public void setVeterinarioId(VeterinarioDomain veterinarioId) {
        this.veterinarioId = veterinarioId;
    }

    public List<VacunacionDomain> getVacunacion() {
        return vacunacion;
    }

    public void setVacunacion(List<VacunacionDomain> vacunacion) {
        this.vacunacion = vacunacion;
    }

    public List<ControlPesoDomain> getControlPeso() {
        return controlPeso;
    }

    public void setControlPeso(List<ControlPesoDomain> controlPeso) {
        this.controlPeso = controlPeso;
    }

    public List<DesparacitacionDomain> getDesparacitacion() {
        return desparacitacion;
    }

    public void setDesparacitacion(List<DesparacitacionDomain> desparacitacion) {
        this.desparacitacion = desparacitacion;
    }

    public List<CirujiaDomain> getCirujia() {
        return cirujia;
    }

    public void setCirujia(List<CirujiaDomain> cirujia) {
        this.cirujia = cirujia;
    }

    public List<NotificacionDomain> getNotificacion() {
        return notificacion;
    }

    public void setNotificacion(List<NotificacionDomain> notificacion) {
        this.notificacion = notificacion;
    }
}
