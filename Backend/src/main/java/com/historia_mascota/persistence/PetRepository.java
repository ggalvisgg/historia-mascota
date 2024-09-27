package com.historia_mascota.persistence;

import com.historia_mascota.domain.MascotaDomain;
import com.historia_mascota.domain.repository.MascotaRepository;
import com.historia_mascota.persistence.crud.OwnerCRUDRepository;
import com.historia_mascota.persistence.crud.PetCRUDRepository;
import com.historia_mascota.persistence.crud.VetCRUDRepository;
import com.historia_mascota.persistence.entity.OwnerEntity;
import com.historia_mascota.persistence.entity.PetEntity;
import com.historia_mascota.persistence.entity.VetEntity;
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
    private VetCRUDRepository vetCRUDRepository;

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

    @Override
    public MascotaDomain guardarMascota(MascotaDomain mascotaDomain) {

        System.out.println(mascotaDomain.getId());
        System.out.println(mascotaDomain.getEdad());
        System.out.println(mascotaDomain.getGenero());
        System.out.println(mascotaDomain.getRaza());
        System.out.println(mascotaDomain.getTipoMascota());
        System.out.println(mascotaDomain.getDuenioId().getId());
        System.out.println(mascotaDomain.getVeterinarioId().getId());

        PetEntity pet = mapper.toPet(mascotaDomain);

        Optional<OwnerEntity> ownerEntity = ownerCRUDRepository.findById(mascotaDomain.getDuenioId().getId());
        Optional<VetEntity> vetEntity = vetCRUDRepository.findById(mascotaDomain.getVeterinarioId().getId());

        System.out.println("Antes de: -------------------------------------");

        ownerEntity.ifPresent(pet::setOwner);
        vetEntity.ifPresent(pet::setVet);

        System.out.println(pet.getIdPet());
        System.out.println(pet.getAgePet());
        System.out.println(pet.getGenderPet());
        System.out.println(pet.getSpeciesPet());
        System.out.println(pet.getTypePet());
        System.out.println(pet.getOwner());
        System.out.println(pet.getVet().getIdVet());

        return mapper.toMascota(petCRUDRepository.save(pet));
    }

    @Override
    public void eliminarMascota(int idMascota) {
        petCRUDRepository.deleteById(idMascota);
    }
}
