package com.historia_mascota.domain.service;

import com.historia_mascota.domain.TipoCirujiaDomain;
import com.historia_mascota.domain.repository.TipoCirujiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoCirujiaService {

    @Autowired
    private TipoCirujiaRepository tipoCirujiaRepository;

    public List<TipoCirujiaDomain> obtenerTodo() {
        return tipoCirujiaRepository.traerTodosTipos();
    }

    public Optional<TipoCirujiaDomain> obtenerPorId(int id) {
        return tipoCirujiaRepository.traerPorId(id);
    }

    public TipoCirujiaDomain guardarTipoCirujia(TipoCirujiaDomain tipoCirujiaDomain) {
        TipoCirujiaDomain tipoCirujia = tipoCirujiaRepository.guardarTipo(tipoCirujiaDomain);
        return tipoCirujia;
    }
}
