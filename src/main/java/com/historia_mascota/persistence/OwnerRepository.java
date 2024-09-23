package com.historia_mascota.persistence;

import com.historia_mascota.domain.DuenioDomain;
import com.historia_mascota.domain.repository.DuenioRepository;
import com.historia_mascota.persistence.crud.OwnerCRUDRepository;
import com.historia_mascota.persistence.entity.OwnerEntity;
import com.historia_mascota.persistence.mapper.DuenioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class OwnerRepository implements DuenioRepository {

    @Autowired
    private OwnerCRUDRepository ownerCRUDRepository;

    @Autowired
    private DuenioMapper mapper;

    @Override
    public List<DuenioDomain> traerTodosDuenios() {
        List<OwnerEntity> owners = (List<OwnerEntity>) ownerCRUDRepository.findAll();
        return mapper.toDuenios(owners);
    }

    @Override
    public boolean existeDuenio(int idOwner){
        return ownerCRUDRepository.existsByIdOwner(idOwner);
    }

    @Override
    public Optional<List<DuenioDomain>> traerPorNombre(String nameOwner) {
        List<OwnerEntity> owners =
                ownerCRUDRepository.findByNameOwner(nameOwner);
        return Optional.of(mapper.toDuenios(owners));
    }

    @Override
    public Optional<List<DuenioDomain>> traerPorEdad(int ageOwner) {
        List<OwnerEntity> owners =
                ownerCRUDRepository.findByAgeOwner(ageOwner);
        return Optional.of(mapper.toDuenios(owners));
    }

    @Override
    public Optional<DuenioDomain> traerPorIdentificacion(int idOwner) {
        return ownerCRUDRepository.findById(idOwner)
                .map(owner -> mapper.toDuenio(owner));
    }

    @Override
    public DuenioDomain guardarDuenio(DuenioDomain duenioDomain) {
        OwnerEntity owner = mapper.toOwner(duenioDomain);
        return mapper.toDuenio(ownerCRUDRepository.save(owner));
    }

    @Override
    public void eliminarDuenio(int idOwner) {
        ownerCRUDRepository.deleteById(idOwner);
    }
}












