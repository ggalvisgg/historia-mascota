package com.historia_mascota.persistence;

import com.historia_mascota.domain.DesparacitacionDomain;
import com.historia_mascota.domain.repository.DesparacitacionRepository;
import com.historia_mascota.persistence.mapper.DesparacitacionMapper;

import com.historia_mascota.persistence.crud.DewormingCRUDRepository;
import com.historia_mascota.persistence.crud.VetCRUDRepository;
import com.historia_mascota.persistence.crud.TypeDewormingCRUDRepository;
import com.historia_mascota.persistence.crud.PetCRUDRepository;

import com.historia_mascota.persistence.entity.DewormingEntity;
import com.historia_mascota.persistence.entity.PetEntity;
import com.historia_mascota.persistence.entity.VetEntity;
import com.historia_mascota.persistence.entity.TypeDewormingEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DewormingRepository implements DesparacitacionRepository {

    @Autowired
    private DewormingCRUDRepository dewormingCRUDRepository;

    @Autowired
    private VetCRUDRepository vetCRUDRepository;

    @Autowired
    private TypeDewormingCRUDRepository typeDewormingCRUDRepository;

    @Autowired
    private PetCRUDRepository petCRUDRepository;

    @Autowired
    private DesparacitacionMapper mapper;

    @Override
    public List<DesparacitacionDomain> traerTodasDesparacitaciones() {
        List<DewormingEntity> dewormings = (List<DewormingEntity>) dewormingCRUDRepository.findAll();
        return mapper.toDesparacitaciones(dewormings);
    }

    @Override
    public Optional<DesparacitacionDomain> traerPorId(int idDeworming) {
        return dewormingCRUDRepository.findById(idDeworming)
                .map(deworming -> mapper.toDesparacitacion(deworming));
    }

    @Override
    public DesparacitacionDomain guardarDesparacitacion(DesparacitacionDomain desparacitacionDomain) {

        DewormingEntity deworming = mapper.toDeworming(desparacitacionDomain);

        Optional<VetEntity> vetEntity = vetCRUDRepository.findById(desparacitacionDomain.getVeterinario().getId());
        Optional<TypeDewormingEntity> typeDewormingEntity = typeDewormingCRUDRepository.findById(desparacitacionDomain.getTipo().getId());
        Optional<PetEntity> petEntity = petCRUDRepository.findById(desparacitacionDomain.getMascota().getId());

        System.out.println("despues de mapear: buscados con el optional de cada uno");


        vetEntity.ifPresent(deworming::setVet);
        typeDewormingEntity.ifPresent(deworming::setTypeDeworming);
        petEntity.ifPresent(deworming::setPet);

        System.out.println(vetEntity.get().getIdVet());
        System.out.println(vetEntity.get().getNameVet());
        System.out.println(petEntity.get().getIdPet());
        System.out.println(petEntity.get().getNamePet());

        System.out.println("ahora vamos a ver si esta guardando en el deworming");
        System.out.println(deworming.getPet().getIdPet());
        System.out.println(deworming.getPet().getNamePet());
        System.out.println("---------------arriba pet, abajo vet");
        System.out.println(deworming.getVet().getIdVet());
        System.out.println(deworming.getVet().getNameVet());

        return mapper.toDesparacitacion(dewormingCRUDRepository.save(deworming));
    }

    @Override
    public void eliminarDesparacitacion(int id) {
        dewormingCRUDRepository.deleteById(id);
    }
}
