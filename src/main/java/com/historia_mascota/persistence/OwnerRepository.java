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

    //x
    @Autowired
    private OwnerCRUDRepository ownerCRUDRepository;

    @Autowired
    private DuenioMapper mapper;

    //solo se cambio de toProducts a toDuenios, siguiendo la logica del profesor
    @Override
    public List<DuenioDomain> getAll() {
        List<OwnerEntity> owners = (List<OwnerEntity>) ownerCRUDRepository.findAll();
        return mapper.toDuenios(owners);
    }

    @Override
    public Optional<List<DuenioDomain>> getByName(String nameOwner) {
        List<OwnerEntity> owners =
                ownerCRUDRepository.getByName(nameOwner);
        return Optional.of(mapper.toDuenios(owners));
    }


    @Override
    public Optional<List<DuenioDomain>> getByAge(int ageOwner) {
        List<OwnerEntity> owners =
                ownerCRUDRepository.getByAge(ageOwner);
        return Optional.of(mapper.toDuenios(owners));
    }

    @Override
    public Optional<DuenioDomain> getOwner(int idOwner) {
        return ownerCRUDRepository.getOwner(idOwner)
                .map(owner -> mapper.toDuenio(owner));
    }

    @Override
    public DuenioDomain save(DuenioDomain duenioDomain) {
        OwnerEntity owner = mapper.toOwner(duenioDomain);
        return mapper.toDuenio(ownerCRUDRepository.save(owner));
    }




    /*
    @Override
    public Optional<List<DuenioDomain>> getByName(String nameOwner) {
        Optional<List<OwnerEntity>> owners =
                ownerCRUDRepository.getByName(nameOwner);
        return Optional.of(mapper.toDuenios(owners));
    }



    @Override
    public Optional<List<DuenioDomain>> getByAge(int ageOwner) {
        Optional<List<OwnerEntity>> owners =
                ownerCRUDRepository.getByAge(ageOwner);
        return Optional.of(mapper.toProducts(owners));
    }



    @Override
    public Optional<DuenioDomain> getOwner(int idOwner) {
        return ownerCRUDRepository.getOwner(idOwner).map(owner -> mapper.toProduct(owner));
    }



    @Override
    public DuenioDomain save(DuenioDomain duenioDomain) {
        OwnerEntity owner = mapper.toProducto(duenioDomain);
        return mapper.toProduct(ownerCRUDRepository.save(owner));
    }
    */

    @Override
    public void delete(int idOwner) {
        ownerCRUDRepository.deleteById(idOwner);
    }
}












