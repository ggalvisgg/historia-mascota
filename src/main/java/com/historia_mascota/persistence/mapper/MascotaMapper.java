package com.historia_mascota.persistence.mapper;

import com.historia_mascota.domain.MascotaDomain;
import com.historia_mascota.persistence.entity.PetEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface MascotaMapper {

    @Mappings({
            @Mapping(source = "idPet", target = "id"),
            @Mapping(source = "namePet", target = "nombre"),
            @Mapping(source = "typePet", target = "tipoMascota"),
            @Mapping(source = "speciesPet", target = "raza"),
            @Mapping(source = "agePet", target = "edad"),
            @Mapping(source = "genderPet", target = "genero"),
            @Mapping(source = "owner", target = "duenioId"),
            @Mapping(source = "vet", target = "veterinarioId"),
            @Mapping(source = "vacunation", target = "vacunacion"),
            @Mapping(source = "weight", target = "controlPeso"),
            @Mapping(source = "deworming", target = "desparacitacion"),
            @Mapping(source = "surgery", target = "cirujia"),
            @Mapping(source = "notification", target = "notificacion")
    })
    MascotaDomain toMascota(PetEntity petEntity);
    List<MascotaDomain> toMascotas(List<PetEntity> pets);

    @InheritInverseConfiguration
    PetEntity toPet(MascotaDomain mascotaDomain);


}




