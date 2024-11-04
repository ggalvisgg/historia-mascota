package com.historia_mascota.domain.repository;

import com.historia_mascota.domain.TipoCirujiaDomain;

import java.util.List;
import java.util.Optional;

public interface TipoCirujiaRepository {

    List<TipoCirujiaDomain> traerTodosTipos();
    Optional<TipoCirujiaDomain> traerPorId(int id);
    TipoCirujiaDomain guardarTipo(TipoCirujiaDomain tipoCirujiaDomain);
}
