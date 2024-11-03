package com.historia_mascota.persistence.mapper;

import com.historia_mascota.domain.VeterinarioDomain;
import com.historia_mascota.persistence.entity.VetEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {MascotaMapper.class})
public interface VeterinarioMapper {

    @Mappings({
            @Mapping(source = "idVet", target = "id"),
            @Mapping(source = "nameVet", target = "nombre"),
            @Mapping(source = "specialtyVet", target = "especialidad"),
            @Mapping(source = "phoneVet", target = "telefono"),
            @Mapping(source = "surgery", target = "cirujias"),
            @Mapping(source = "pet", target = "mascotas"),  // Mapea mascotas a través de MascotaMapper
            @Mapping(source = "deworming", target = "desparacitaciones"),
            @Mapping(source = "weight", target = "controlPeso")
    })
    VeterinarioDomain toVeterinario(VetEntity vetEntity);

    List<VeterinarioDomain> toVeterinarios(List<VetEntity> vets);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "pet", ignore = true),       // Ignora la relación con mascotas en el mapeo inverso
            @Mapping(target = "surgery", ignore = true),    // Ignora cirugías para evitar recursividad
            @Mapping(target = "deworming", ignore = true),  // Ignora desparacitaciones en el mapeo inverso
            @Mapping(target = "weight", ignore = true)      // Ignora control de peso en el mapeo inverso
    })
    VetEntity toVet(VeterinarioDomain veterinarioDomain);
}
