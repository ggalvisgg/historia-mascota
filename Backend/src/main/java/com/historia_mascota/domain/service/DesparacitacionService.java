package com.historia_mascota.domain.service;

import com.historia_mascota.domain.DesparacitacionDomain;
import com.historia_mascota.domain.repository.DesparacitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DesparacitacionService {

    @Autowired
    private DesparacitacionRepository desparacitacionRepository;

    public List<DesparacitacionDomain> obtenerTodo() {
        return desparacitacionRepository.traerTodasDesparacitaciones();
    }

    public Optional<DesparacitacionDomain> obtenerPorId(int id) {
        return desparacitacionRepository.traerPorId(id);
    }

    public DesparacitacionDomain guardarDesparacitacion(DesparacitacionDomain desparacitacionDomain) {
        return desparacitacionRepository.guardarDesparacitacion(desparacitacionDomain);
    }

    public boolean eliminarDesparacitacion(int id) {
        return obtenerPorId(id).map(product -> {
            desparacitacionRepository.eliminarDesparacitacion(id);
            return true;
        }).orElse(false);
    }
}
