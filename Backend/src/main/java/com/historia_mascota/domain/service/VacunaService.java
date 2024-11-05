package com.historia_mascota.domain.service;

import com.historia_mascota.domain.VacunaDomain;
import com.historia_mascota.domain.repository.VacunaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VacunaService {

    @Autowired
    private VacunaRepository vacunaRepository;

    public List<VacunaDomain> obtenerTodo() {
        return vacunaRepository.traerTodasVacunas();
    }

    public Optional<VacunaDomain> obtenerPorId(int id) {
        return vacunaRepository.traerPorId(id);
    }

    public VacunaDomain guardarVacuna(VacunaDomain vacunaDomain) {
        return vacunaRepository.guardarVacuna(vacunaDomain);
    }

    public boolean eliminarVacuna(int id) {
        return obtenerPorId(id).map(product -> {
            vacunaRepository.eliminarVacuna(id);
            return true;
        }).orElse(false);
    }
}
