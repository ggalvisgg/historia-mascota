package com.historia_mascota.persistence.mapper;

import com.historia_mascota.domain.VeterinarioDomain;
import com.historia_mascota.domain.UsuarioDomain;
import com.historia_mascota.persistence.entity.VetEntity;
import com.historia_mascota.persistence.entity.UserEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface VeterinarioMapper {

    @Mappings({
            @Mapping(source = "idVet", target = "id"),
            @Mapping(source = "nameVet", target = "nombre"),
            @Mapping(source = "specialtyVet", target = "especialidad"),
            @Mapping(source = "phoneVet", target = "telefono"),
            @Mapping(source = "surgery", target = "cirujias"),
            @Mapping(source = "pet", target = "mascotas"),
            @Mapping(source = "deworming", target = "desparacitaciones"),
            @Mapping(source = "weight", target = "controlPeso")
    })
    VeterinarioDomain toVeterinario(VetEntity vetEntity);
    List<VeterinarioDomain> toVeterinarios(List<VetEntity> vets);

    @InheritInverseConfiguration
    VetEntity toVet(VeterinarioDomain veterinarioDomain);
}
