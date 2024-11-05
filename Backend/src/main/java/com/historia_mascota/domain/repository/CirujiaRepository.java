package com.historia_mascota.domain.repository;

import com.historia_mascota.domain.CirujiaDomain;

import java.util.List;
import java.util.Optional;

public interface CirujiaRepository {

    List<CirujiaDomain> traerTodasCirujias();
    Optional<CirujiaDomain> traerPorId(int id);
    CirujiaDomain guardarCirujia(CirujiaDomain cirujiaDomain);
    void eliminarCirujia(int id);
}
