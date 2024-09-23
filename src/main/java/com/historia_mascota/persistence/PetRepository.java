package com.historia_mascota.persistence;

import com.historia_mascota.domain.DuenioDomain;
import com.historia_mascota.domain.MascotaDomain;
import com.historia_mascota.domain.repository.MascotaRepository;
import com.historia_mascota.persistence.crud.OwnerCRUDRepository;
import com.historia_mascota.persistence.crud.PetCRUDRepository;
import com.historia_mascota.persistence.entity.OwnerEntity;
import com.historia_mascota.persistence.entity.PetEntity;
import com.historia_mascota.persistence.mapper.MascotaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PetRepository implements MascotaRepository {

    @Autowired
    private PetCRUDRepository petCRUDRepository;

    @Autowired
    private OwnerCRUDRepository ownerCRUDRepository;

    @Autowired
    private MascotaMapper mapper;

    @Override
    public List<MascotaDomain> traerTodasMascotas() {
        List<PetEntity> pets = (List<PetEntity>) petCRUDRepository.findAll();
        return mapper.toMascotas(pets);
    }

    @Override
    public Optional<List<MascotaDomain>> traerMascotaPorNombre(String namePet) {
        List<PetEntity> pets =
                petCRUDRepository.findByNamePet(namePet);
        return Optional.of(mapper.toMascotas(pets));
    }

    @Override
    public Optional<List<MascotaDomain>> traerMascotaPorRaza(String raza) {
        List<PetEntity> pets =
                petCRUDRepository.findBySpeciesPet(raza);
        return Optional.of(mapper.toMascotas(pets));
    }

    @Override
    public Optional<List<MascotaDomain>> traerMascotaPorGenero(String genero) {
        List<PetEntity> pets =
                petCRUDRepository.findByGenderPet(genero);
        return Optional.of(mapper.toMascotas(pets));
    }

    @Override
    public Optional<MascotaDomain> traerPorId(int idMascota) {
        return petCRUDRepository.findById(idMascota)
                .map(pet -> mapper.toMascota(pet));
    }

    /*
    @Override
    public MascotaDomain guardarMascota(MascotaDomain mascotaDomain) {

        if (ownerCRUDRepository.existsByIdOwner(mascotaDomain.getDuenioIde())) {
            throw new RuntimeException("Owner not found");
        }

        OwnerEntity owner = ownerCRUDRepository.findById(mascotaDomain.getDuenioIde())
                .orElseThrow(() -> new RuntimeException("Owner not found"));

        PetEntity pet = mapper.toPet(mascotaDomain);

        PetEntity petFinal = new PetEntity();
        petFinal.setOwner(owner);
        petFinal.setNamePet(pet.getNamePet());
        petFinal.setIdPet(pet.getIdPet());



        return mapper.toMascota(petCRUDRepository.save(petFinal));
    }

     */


    @Override
    public MascotaDomain guardarMascota(MascotaDomain mascotaDomain) {
        PetEntity pet = mapper.toPet(mascotaDomain);
        return mapper.toMascota(petCRUDRepository.save(pet));
    }



    @Override
    public void eliminarMascota(int idMascota) {
        petCRUDRepository.deleteById(idMascota);
    }
}
