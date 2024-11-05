package com.historia_mascota.domain.repository;

import com.historia_mascota.domain.ControlPesoDomain;

import java.util.List;
import java.util.Optional;

public interface ControlPesoRepository {

    List<ControlPesoDomain> traerTodasControles();
    Optional<ControlPesoDomain> traerPorId(int id);
    ControlPesoDomain guardarControlPeso(ControlPesoDomain controlPesoDomain);
    void eliminarControlPeso(int id);
}
