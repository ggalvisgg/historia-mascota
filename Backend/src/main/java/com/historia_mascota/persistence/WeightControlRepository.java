package com.historia_mascota.persistence;

import com.historia_mascota.domain.ControlPesoDomain;
import com.historia_mascota.domain.repository.ControlPesoRepository;
import com.historia_mascota.persistence.mapper.ControlPesoMapper;

import com.historia_mascota.persistence.crud.WeightControlCRUDRepository;
import com.historia_mascota.persistence.crud.VetCRUDRepository;
import com.historia_mascota.persistence.crud.PetCRUDRepository;

import com.historia_mascota.persistence.entity.WeightControlEntity;
import com.historia_mascota.persistence.entity.PetEntity;
import com.historia_mascota.persistence.entity.VetEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class WeightControlRepository implements ControlPesoRepository {

    @Autowired
    private WeightControlCRUDRepository weightControlCRUDRepository;

    @Autowired
    private VetCRUDRepository vetCRUDRepository;

    @Autowired
    private PetCRUDRepository petCRUDRepository;

    @Autowired
    private ControlPesoMapper mapper;

    @Override
    public List<ControlPesoDomain> traerTodasControles() {
        List<WeightControlEntity> weightControls = (List<WeightControlEntity>) weightControlCRUDRepository.findAll();
        return mapper.toControlPesos(weightControls);
    }

    @Override
    public Optional<ControlPesoDomain> traerPorId(int idWeightControl) {
        return weightControlCRUDRepository.findById(idWeightControl)
                .map(weightControl -> mapper.toControlPeso(weightControl));
    }

    @Override
    public ControlPesoDomain guardarControlPeso(ControlPesoDomain controlPesoDomain) {

        WeightControlEntity weightControl = mapper.toWeightControl(controlPesoDomain);

        Optional<VetEntity> vetEntity = vetCRUDRepository.findById(controlPesoDomain.getVeterinario().getId());
        Optional<PetEntity> petEntity = petCRUDRepository.findById(controlPesoDomain.getMascota().getId());

        vetEntity.ifPresent(weightControl::setVet);
        petEntity.ifPresent(weightControl::setPet);
        return mapper.toControlPeso(weightControlCRUDRepository.save(weightControl));
    }

    @Override
    public void eliminarControlPeso(int id) {
        weightControlCRUDRepository.deleteById(id);
    }
}
