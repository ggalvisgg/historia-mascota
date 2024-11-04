package com.historia_mascota.domain.repository;

import com.historia_mascota.domain.TipoDesparacitacionDomain;

import java.util.List;
import java.util.Optional;

public interface TipoDesparacitacionRepository {

    List<TipoDesparacitacionDomain> traerTodosTipos();
    Optional<TipoDesparacitacionDomain> traerPorId(int id);
    TipoDesparacitacionDomain guardarTipo(TipoDesparacitacionDomain tipoDesparacitacionDomain);
}
