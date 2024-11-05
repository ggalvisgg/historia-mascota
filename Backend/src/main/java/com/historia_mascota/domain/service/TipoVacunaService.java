package com.historia_mascota.domain.service;

import com.historia_mascota.domain.TipoVacunaDomain;
import com.historia_mascota.domain.repository.TipoVacunaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoVacunaService {

    @Autowired
    private TipoVacunaRepository tipoVacunaRepository;

    public List<TipoVacunaDomain> obtenerTodo() {
        return tipoVacunaRepository.traerTodosTiposVacunas();
    }

    public Optional<TipoVacunaDomain> obtenerPorId(int id) {
        return tipoVacunaRepository.traerPorId(id);
    }

    public TipoVacunaDomain guardarTipoVacuna(TipoVacunaDomain tipoVacunaDomain) {
        TipoVacunaDomain tipoVacuna = tipoVacunaRepository.guardarTipoVacuna(tipoVacunaDomain);
        return tipoVacuna;
    }
}
