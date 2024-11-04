package com.historia_mascota.persistence;

import com.historia_mascota.domain.TipoCirujiaDomain;
import com.historia_mascota.domain.repository.TipoCirujiaRepository;
import com.historia_mascota.persistence.crud.TypeSurgeryCRUDRepository;
import com.historia_mascota.persistence.entity.TypeSurgeryEntity;
import com.historia_mascota.persistence.mapper.TipoCirujiaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TypeSurgeryRepository implements TipoCirujiaRepository {

    @Autowired
    private TypeSurgeryCRUDRepository typeSurgeryCRUDRepository;

    @Autowired
    private TipoCirujiaMapper mapper;

    @Override
    public List<TipoCirujiaDomain> traerTodosTipos() {
        List<TypeSurgeryEntity> typeSurgerys = (List<TypeSurgeryEntity>) typeSurgeryCRUDRepository.findAll();
        return mapper.toTipoCirujias(typeSurgerys);
    }

    @Override
    public Optional<TipoCirujiaDomain> traerPorId(int id) {
        return typeSurgeryCRUDRepository.findById(id)
                .map(surgery -> mapper.toTipoCirujia(surgery));
    }

    @Override
    public TipoCirujiaDomain guardarTipo(TipoCirujiaDomain tipoCirujiaDomain) {
        TypeSurgeryEntity typeSurgery = mapper.toTypeSurgery(tipoCirujiaDomain);
        return mapper.toTipoCirujia(typeSurgeryCRUDRepository.save(typeSurgery));
    }
}
