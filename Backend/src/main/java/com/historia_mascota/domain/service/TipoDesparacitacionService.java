package com.historia_mascota.domain.service;

import com.historia_mascota.domain.TipoDesparacitacionDomain;
import com.historia_mascota.domain.repository.TipoDesparacitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoDesparacitacionService {

    @Autowired
    private TipoDesparacitacionRepository tipoDesparacitacionRepository;

    public List<TipoDesparacitacionDomain> obtenerTodo() {
        return tipoDesparacitacionRepository.traerTodosTipos();
    }

    public Optional<TipoDesparacitacionDomain> obtenerPorId(int id) {
        return tipoDesparacitacionRepository.traerPorId(id);
    }

    public TipoDesparacitacionDomain guardarTipoDesparacitacion(TipoDesparacitacionDomain tipoDesparacitacionDomain) {
        TipoDesparacitacionDomain tipoDesparacitacion= tipoDesparacitacionRepository.guardarTipo(tipoDesparacitacionDomain);
        return tipoDesparacitacion;
    }
}
