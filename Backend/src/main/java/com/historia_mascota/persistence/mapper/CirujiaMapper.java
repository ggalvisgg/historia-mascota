package com.historia_mascota.persistence.mapper;

import com.historia_mascota.domain.CirujiaDomain;
import com.historia_mascota.persistence.entity.SurgeryEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", uses = {MascotaMapper.class, TipoCirujiaMapper.class})
public interface CirujiaMapper {

    @Mappings({
            @Mapping(source = "idSurgery", target = "id"),
            @Mapping(source = "dateSurgery", target = "fecha"),
            @Mapping(source = "hourSurgery", target = "hora"),
            @Mapping(source = "stateSurgery", target = "estado"),
            @Mapping(source = "observation", target = "observacion"),
            //@Mapping(source = "vet", target = "veterinario"),
            @Mapping(source = "pet", target = "mascota"),
            @Mapping(source = "typeSurgery", target = "tipo")
    })
    CirujiaDomain toCirujia(SurgeryEntity surgeryEntity);

    List<CirujiaDomain> toCirujias(List<SurgeryEntity> surgerys);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "pet", ignore = true),
            @Mapping(target = "typeSurgery", ignore = true)
    })
    SurgeryEntity toSurgery(CirujiaDomain cirujiaDomain);
}
