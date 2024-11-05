package com.historia_mascota.domain.repository;

import com.historia_mascota.domain.TipoVacunaDomain;

import java.util.List;
import java.util.Optional;

public interface TipoVacunaRepository {

    List<TipoVacunaDomain> traerTodosTiposVacunas();
    Optional<TipoVacunaDomain> traerPorId(int id);
    TipoVacunaDomain guardarTipoVacuna(TipoVacunaDomain tipoVacunaDomain);
}
