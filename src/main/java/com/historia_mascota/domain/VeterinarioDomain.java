package com.historia_mascota.domain;

import java.util.List;

public class VeterinarioDomain {

    private int id;
    private String nombre;
    private String especialidad;
    private String telefono;
    private List<CirujiaDomain> cirujias;
    private List<MascotaDomain> mascotas;
    private List<DesparacitacionDomain> desparacitaciones;
    private List<ControlPesoDomain> controlPeso;

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

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<CirujiaDomain> getCirujias() {
        return cirujias;
    }

    public void setCirujias(List<CirujiaDomain> cirujias) {
        this.cirujias = cirujias;
    }

    public List<MascotaDomain> getMascotas() {
        return mascotas;
    }

    public void setMascotas(List<MascotaDomain> mascotas) {
        this.mascotas = mascotas;
    }

    public List<DesparacitacionDomain> getDesparacitaciones() {
        return desparacitaciones;
    }

    public void setDesparacitaciones(List<DesparacitacionDomain> desparacitaciones) {
        this.desparacitaciones = desparacitaciones;
    }

    public List<ControlPesoDomain> getControlPeso() {
        return controlPeso;
    }

    public void setControlPeso(List<ControlPesoDomain> controlPeso) {
        this.controlPeso = controlPeso;
    }
}
