package com.historia_mascota.domain.service;

import com.historia_mascota.domain.CirujiaDomain;
import com.historia_mascota.domain.repository.CirujiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CirujiaService {

    @Autowired
    private CirujiaRepository cirujiaRepository;

    public List<CirujiaDomain> obtenerTodo() {
        return cirujiaRepository.traerTodasCirujias();
    }

    public Optional<CirujiaDomain> obtenerPorId(int id) {
        return cirujiaRepository.traerPorId(id);
    }

    public CirujiaDomain guardarCirujia(CirujiaDomain cirujiaDomain) {
        return cirujiaRepository.guardarCirujia(cirujiaDomain);
    }

    public boolean eliminarCirujia(int id) {
        return obtenerPorId(id).map(product -> {
            cirujiaRepository.eliminarCirujia(id);
            return true;
        }).orElse(false);
    }
}
