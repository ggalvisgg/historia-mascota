package com.historia_mascota.domain.repository;

import com.historia_mascota.domain.VacunaDomain;

import java.util.List;
import java.util.Optional;

public interface VacunaRepository {

    List<VacunaDomain> traerTodasVacunas();
    Optional<VacunaDomain> traerPorId(int id);
    VacunaDomain guardarVacuna(VacunaDomain vacunaDomain);
    void eliminarVacuna(int id);
}
