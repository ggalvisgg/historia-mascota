package com.historia_mascota.domain.service;

import com.historia_mascota.domain.ControlPesoDomain;
import com.historia_mascota.domain.repository.ControlPesoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ControlPesoService {

    @Autowired
    private ControlPesoRepository controlPesoRepository;

    public List<ControlPesoDomain> obtenerTodo() {
        return controlPesoRepository.traerTodasControles();
    }

    public Optional<ControlPesoDomain> obtenerPorId(int id) {
        return controlPesoRepository.traerPorId(id);
    }

    public ControlPesoDomain guardarControlPeso(ControlPesoDomain controlPesoDomain) {
        return controlPesoRepository.guardarControlPeso(controlPesoDomain);
    }

    public boolean eliminarControlPeso(int id) {
        return obtenerPorId(id).map(product -> {
            controlPesoRepository.eliminarControlPeso(id);
            return true;
        }).orElse(false);
    }
}
