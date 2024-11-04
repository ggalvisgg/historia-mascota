package com.historia_mascota.domain.repository;

import com.historia_mascota.domain.DesparacitacionDomain;

import java.util.List;
import java.util.Optional;

public interface DesparacitacionRepository {

    List<DesparacitacionDomain> traerTodasDesparacitaciones();
    Optional<DesparacitacionDomain> traerPorId(int id);
    DesparacitacionDomain guardarDesparacitacion(DesparacitacionDomain desparacitacionDomain);
    void eliminarDesparacitacion(int id);
}
