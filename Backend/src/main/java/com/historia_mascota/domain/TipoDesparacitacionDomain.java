package com.historia_mascota.domain;

import java.util.List;

public class TipoDesparacitacionDomain {

    private int id;
    private String descripcion;
    private List<DesparacitacionDomain> desparacitacion;

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

    public List<DesparacitacionDomain> getDesparacitacion() {
        return desparacitacion;
    }

    public void setDesparacitacion(List<DesparacitacionDomain> desparacitacion) {
        this.desparacitacion = desparacitacion;
    }
}
