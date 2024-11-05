package com.historia_mascota.persistence;

import com.historia_mascota.domain.CirujiaDomain;
import com.historia_mascota.domain.repository.CirujiaRepository;
import com.historia_mascota.persistence.mapper.CirujiaMapper;

import com.historia_mascota.persistence.crud.SurgeryCRUDRepositoy;
import com.historia_mascota.persistence.crud.VetCRUDRepository;
import com.historia_mascota.persistence.crud.TypeSurgeryCRUDRepository;
import com.historia_mascota.persistence.crud.PetCRUDRepository;

import com.historia_mascota.persistence.entity.SurgeryEntity;
import com.historia_mascota.persistence.entity.PetEntity;
import com.historia_mascota.persistence.entity.VetEntity;
import com.historia_mascota.persistence.entity.TypeSurgeryEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SurgeryRepository implements CirujiaRepository {

    @Autowired
    private SurgeryCRUDRepositoy surgeryCRUDRepositoy;

    @Autowired
    private VetCRUDRepository vetCRUDRepository;

    @Autowired
    private TypeSurgeryCRUDRepository typeSurgeryCRUDRepository;

    @Autowired
    private PetCRUDRepository petCRUDRepository;

    @Autowired
    private CirujiaMapper mapper;

    @Override
    public List<CirujiaDomain> traerTodasCirujias() {
        List<SurgeryEntity> surgerys = (List<SurgeryEntity>) surgeryCRUDRepositoy.findAll();
        return mapper.toCirujias(surgerys);
    }

    @Override
    public Optional<CirujiaDomain> traerPorId(int id) {
        return surgeryCRUDRepositoy.findById(id)
                .map(surgery -> mapper.toCirujia(surgery));
    }

    @Override
    public CirujiaDomain guardarCirujia(CirujiaDomain cirujiaDomain) {

        SurgeryEntity surgery = mapper.toSurgery(cirujiaDomain);

        Optional<VetEntity> vetEntity = vetCRUDRepository.findById(cirujiaDomain.getVeterinario().getId());
        Optional<PetEntity> petEntity = petCRUDRepository.findById(cirujiaDomain.getMascota().getId());
        Optional<TypeSurgeryEntity> typeSurgeryEntity = typeSurgeryCRUDRepository.findById(cirujiaDomain.getTipo().getId());

        vetEntity.ifPresent(surgery::setVet);
        typeSurgeryEntity.ifPresent(surgery::setTypeSurgery);
        petEntity.ifPresent(surgery::setPet);

        return mapper.toCirujia(surgeryCRUDRepositoy.save(surgery));
    }

    @Override
    public void eliminarCirujia(int id) {
        surgeryCRUDRepositoy.deleteById(id);
    }
}
