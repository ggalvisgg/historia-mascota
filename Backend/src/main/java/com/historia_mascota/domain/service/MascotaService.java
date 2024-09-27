package com.historia_mascota.domain.service;

import com.historia_mascota.domain.MascotaDomain;
import com.historia_mascota.domain.repository.DuenioRepository;
import com.historia_mascota.domain.repository.MascotaRepository;
import com.historia_mascota.persistence.crud.OwnerCRUDRepository;
import com.historia_mascota.persistence.crud.PetCRUDRepository;
import com.historia_mascota.persistence.crud.VetCRUDRepository;
import com.historia_mascota.persistence.entity.OwnerEntity;
import com.historia_mascota.persistence.entity.PetEntity;
import com.historia_mascota.persistence.entity.VetEntity;
import com.historia_mascota.persistence.mapper.MascotaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MascotaService {

    @Autowired
    private MascotaRepository mascotaRepository;

    @Autowired
    private PetCRUDRepository petCRUDRepository;

    @Autowired
    private OwnerCRUDRepository ownerCRUDRepository;

    @Autowired
    private VetCRUDRepository vetCRUDRepository;

    @Autowired
    private MascotaMapper mapper;

    public List<MascotaDomain> obtenerTodo() {
        return mascotaRepository.traerTodasMascotas();
    }

    public Optional<MascotaDomain> obtenerPorId(int idMascota) {
        return mascotaRepository.traerPorId(idMascota);
    }

    public Optional<List<MascotaDomain>> obtenerPorNombre(String nombre) {
        return mascotaRepository.traerMascotaPorNombre(nombre);
    }

    public Optional<List<MascotaDomain>> obtenerPorGenero(String genero) {
        return mascotaRepository.traerMascotaPorGenero(genero);
    }

    public Optional<List<MascotaDomain>> obtenerPorRaza(String raza) {
        return mascotaRepository.traerMascotaPorRaza(raza);
    }

    //public MascotaDomain guardarMascota(MascotaDomain mascotaDomain) {
//        return mascotaRepository.guardarMascota(mascotaDomain);
  //  }

    public MascotaDomain guardarMascota(MascotaDomain mascotaDomain) {
        PetEntity pet = mapper.toPet(mascotaDomain);

        Optional<OwnerEntity> ownerEntity = ownerCRUDRepository.findById(mascotaDomain.getDuenioId().getId());
        Optional<VetEntity> vetEntity = vetCRUDRepository.findById(mascotaDomain.getVeterinarioId().getId());

        ownerEntity.ifPresent(pet::setOwner);
        vetEntity.ifPresent(pet::setVet);

        return mapper.toMascota(petCRUDRepository.save(pet));
    }


    public boolean eliminarMascota(int idMascota) {
        return obtenerPorId(idMascota).map(product -> {
            mascotaRepository.eliminarMascota(idMascota);
            return true;
        }).orElse(false);
    }

}
