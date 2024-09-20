package com.historia_mascota.domain.service;

import com.historia_mascota.domain.DuenioDomain;
import com.historia_mascota.domain.repository.DuenioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DuenioService {

    @Autowired
    private DuenioRepository duenioRepository;

    public List<DuenioDomain> obtenerTodo() {
        return duenioRepository.traerTodosDuenios();
    }

    public Optional<DuenioDomain> obtenerPorId(int id) {
        return duenioRepository.traerPorIdentificacion(id);
    }

    public Optional<List<DuenioDomain>> obtenerPorNombre(String name) {
        return duenioRepository.traerPorNombre(name);
    }

    public DuenioDomain guardarDuenio(DuenioDomain duenioDomain) {
        return duenioRepository.guardarDuenio(duenioDomain);
    }

    public boolean eliminarDuenio(int id) {
        return obtenerPorId(id).map(product -> {
            duenioRepository.eliminarDuenio(id);
            return true;
        }).orElse(false);
    }

}



