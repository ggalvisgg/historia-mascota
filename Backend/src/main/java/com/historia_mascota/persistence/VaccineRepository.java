package com.historia_mascota.persistence;

import com.historia_mascota.domain.VacunaDomain;

import com.historia_mascota.domain.repository.VacunaRepository;
import com.historia_mascota.persistence.crud.VaccineCRUDRepository;
import com.historia_mascota.persistence.crud.TypeVaccineCRUDRepository;

import com.historia_mascota.persistence.entity.VaccineEntity;
import com.historia_mascota.persistence.entity.TypeVaccineEntity;

import com.historia_mascota.persistence.mapper.VacunaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class VaccineRepository implements VacunaRepository {

    @Autowired
    private VaccineCRUDRepository vaccineCRUDRepository;

    @Autowired
    private TypeVaccineCRUDRepository typeVaccineCRUDRepository;

    @Autowired
    private VacunaMapper mapper;

    @Override
    public List<VacunaDomain> traerTodasVacunas() {
        List<VaccineEntity> vaccines = (List<VaccineEntity>) vaccineCRUDRepository.findAll();
        return mapper.toVacunas(vaccines);
    }

    @Override
    public Optional<VacunaDomain> traerPorId(int idVaccine) {
        return vaccineCRUDRepository.findById(idVaccine)
                .map(vaccine -> mapper.toVacuna(vaccine));
    }

    @Override
    public VacunaDomain guardarVacuna(VacunaDomain vacunaDomain) {

        VaccineEntity vaccine = mapper.toVaccine(vacunaDomain);
        Optional<TypeVaccineEntity> typeVaccineEntity = typeVaccineCRUDRepository.findById(vacunaDomain.getTipo().getId());

        typeVaccineEntity.ifPresent(vaccine::setTypeVaccine);
        return mapper.toVacuna(vaccineCRUDRepository.save(vaccine));
    }

    @Override
    public void eliminarVacuna(int id) {
        vaccineCRUDRepository.deleteById(id);
    }
}

