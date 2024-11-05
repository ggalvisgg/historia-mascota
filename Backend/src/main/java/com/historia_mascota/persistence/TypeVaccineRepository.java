package com.historia_mascota.persistence;

import com.historia_mascota.domain.TipoVacunaDomain;
import com.historia_mascota.domain.repository.TipoVacunaRepository;
import com.historia_mascota.persistence.crud.TypeVaccineCRUDRepository;
import com.historia_mascota.persistence.entity.TypeVaccineEntity;
import com.historia_mascota.persistence.mapper.TipoVacunaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TypeVaccineRepository implements TipoVacunaRepository  {

    @Autowired
    private TypeVaccineCRUDRepository typeVaccineCRUDRepository;

    @Autowired
    private TipoVacunaMapper mapper;

    @Override
    public List<TipoVacunaDomain> traerTodosTiposVacunas() {
        List<TypeVaccineEntity> typeVaccines = (List<TypeVaccineEntity>) typeVaccineCRUDRepository.findAll();
        return mapper.toTipoVacunas(typeVaccines);
    }

    @Override
    public Optional<TipoVacunaDomain> traerPorId(int id) {
        return typeVaccineCRUDRepository.findById(id)
                .map(typeVaccine -> mapper.toTipoVacuna(typeVaccine));
    }

    @Override
    public TipoVacunaDomain guardarTipoVacuna(TipoVacunaDomain tipoVacunaDomain) {
        TypeVaccineEntity typeVaccine = mapper.toTypeVaccine(tipoVacunaDomain);
        return mapper.toTipoVacuna(typeVaccineCRUDRepository.save(typeVaccine));
    }
}
