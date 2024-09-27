package com.historia_mascota.persistence;

import com.historia_mascota.domain.DuenioDomain;
import com.historia_mascota.domain.VeterinarioDomain;

import com.historia_mascota.domain.repository.VeterinarioRepository;
import com.historia_mascota.persistence.crud.VetCRUDRepository;
import com.historia_mascota.persistence.entity.OwnerEntity;
import com.historia_mascota.persistence.entity.VetEntity;
import com.historia_mascota.persistence.mapper.VeterinarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class VetRepository implements VeterinarioRepository {

    @Autowired
    private VetCRUDRepository vetCRUDRepository;

    @Autowired
    private VeterinarioMapper mapper;

    @Override
    public List<VeterinarioDomain> traerTodosVeterinarios() {
        List<VetEntity> vets = (List<VetEntity>) vetCRUDRepository.findAll();
        return mapper.toVeterinarios(vets);
    }

    @Override
    public boolean existeVet(int id){
        return vetCRUDRepository.existsById(id);
    }

    @Override
    public Optional<List<VeterinarioDomain>> traerPorNombre(String nameVet) {
        List<VetEntity> vets =
                vetCRUDRepository.findByNameVet(nameVet);
        return Optional.of(mapper.toVeterinarios(vets));
    }

    @Override
    public Optional<List<VeterinarioDomain>> traerPorEspecialidad(String specialtyVet) {
        List<VetEntity> vets =
                vetCRUDRepository.findBySpecialtyVet(specialtyVet);
        return Optional.of(mapper.toVeterinarios(vets));
    }

    @Override
    public Optional<VeterinarioDomain> traerPorIdentificacion(int idVet) {
        return vetCRUDRepository.findById(idVet)
                .map(vet -> mapper.toVeterinario(vet));
    }

    @Override
    public VeterinarioDomain guardarVeterinario(VeterinarioDomain veterinarioDomain) {
        VetEntity vet = mapper.toVet(veterinarioDomain);
        return mapper.toVeterinario(vetCRUDRepository.save(vet));
    }

    @Override
    public void eliminarVeterinario(int idVet) {
        vetCRUDRepository.deleteById(idVet);
    }
}
