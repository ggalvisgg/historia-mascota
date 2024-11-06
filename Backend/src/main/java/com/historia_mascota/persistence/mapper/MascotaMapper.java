package com.historia_mascota.persistence.mapper;

import com.historia_mascota.domain.*;
import com.historia_mascota.persistence.entity.*;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", uses = {TipoCirujiaMapper.class})
public interface MascotaMapper {

    @Mappings({
            @Mapping(source = "idPet", target = "id"),
            @Mapping(source = "namePet", target = "nombre"),
            @Mapping(source = "typePet", target = "tipoMascota"),
            @Mapping(source = "speciesPet", target = "raza"),
            @Mapping(source = "agePet", target = "edad"),
            @Mapping(source = "genderPet", target = "genero"),
            @Mapping(source = "owner", target = "duenioId", qualifiedByName = "toDuenioWithoutPets"),
            @Mapping(source = "vet", target = "veterinarioId", qualifiedByName = "toVeterinarioWithoutPets"),
            @Mapping(source = "vacunation", target = "vacunacion"),
            @Mapping(source = "weight", target = "controlPeso", qualifiedByName = "toControlPesoWithoutPets"),
            @Mapping(source = "deworming", target = "desparacitacion", qualifiedByName = "toDesparacitacionWithoutPets"),
            @Mapping(source = "surgery", target = "cirujia",  qualifiedByName = "toCirujiaWithoutPets"),
            @Mapping(source = "notification", target = "notificacion")
    })
    MascotaDomain toMascota(PetEntity petEntity);

    List<MascotaDomain> toMascotas(List<PetEntity> pets);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "owner", ignore = true),
            @Mapping(target = "vet", ignore = true),
            @Mapping(target = "deworming", ignore = true),
            @Mapping(target = "weight", ignore = true),
            @Mapping(target = "surgery", ignore = true)
    })
    PetEntity toPet(MascotaDomain mascotaDomain);

    @Named("toDuenioWithoutPets")
    @Mappings({
            @Mapping(target = "pet", ignore = true),
            @Mapping(source = "idOwner", target = "id"),
            @Mapping(source = "nameOwner", target = "name"),
            @Mapping(source = "lastOwner", target = "last"),
            @Mapping(source = "ageOwner", target = "age"),
            @Mapping(source = "phoneOwner", target = "phone")
    })
    DuenioDomain toDuenioWithoutPets(OwnerEntity ownerEntity);

    @Named("toVeterinarioWithoutPets")
    @Mappings({
            @Mapping(target = "mascotas", ignore = true),  // Ignora la lista de mascotas para evitar recursividad
            @Mapping(source = "idVet", target = "id"),
            @Mapping(source = "nameVet", target = "nombre"),
            @Mapping(source = "specialtyVet", target = "especialidad"),
            @Mapping(source = "phoneVet", target = "telefono"),
            @Mapping(target = "cirujias", ignore = true),
            @Mapping(target = "desparacitaciones", ignore = true),
            @Mapping(target = "controlPeso", ignore = true)
    })
    VeterinarioDomain toVeterinarioWithoutPets(VetEntity vetEntity);

    @Named("toDesparacitacionWithoutPets")
    @Mappings({
            @Mapping(target = "veterinario", ignore = true),
            @Mapping(target = "tipo", ignore = true),
            @Mapping(target = "mascota", ignore = true),
            @Mapping(source = "idDeworming", target = "id"),
            @Mapping(source = "dateDeworming", target = "fecha"),
            @Mapping(source = "type", target = "tipoDesparacitacion"),
            @Mapping(source = "batchControl", target = "lote"),
            @Mapping(source = "boosterControl", target = "refuerzo")
    })
    DesparacitacionDomain toDesparacitacionWithoutPets(DewormingEntity dewormingEntity);

    @Named("toCirujiaWithoutPets")
    @Mappings({
            @Mapping(target = "veterinario", ignore = true),
            @Mapping(target = "mascota", ignore = true),
            //@Mapping(target = "tipo", ignore = true),
            @Mapping(source = "typeSurgery", target = "tipo"),
            @Mapping(source = "idSurgery", target = "id"),
            @Mapping(source = "dateSurgery", target = "fecha"),
            @Mapping(source = "hourSurgery", target = "hora"),
            @Mapping(source = "stateSurgery", target = "estado"),
            @Mapping(source = "observation", target = "observacion")
    })
    CirujiaDomain toCirujiaWithoutPets(SurgeryEntity surgeryEntity);

    @Named("toControlPesoWithoutPets")
    @Mappings({
            @Mapping(target = "veterinario", ignore = true),
            @Mapping(target = "mascota", ignore = true),
            @Mapping(source = "idWeightControl", target = "id"),
            @Mapping(source = "dateWeight", target = "fechaControl"),
            @Mapping(source = "hourWeight", target = "horaControl"),
            @Mapping(source = "weight", target = "peso")
    })
    ControlPesoDomain toControlPesoWithoutPets(WeightControlEntity weightControlEntity);
}
