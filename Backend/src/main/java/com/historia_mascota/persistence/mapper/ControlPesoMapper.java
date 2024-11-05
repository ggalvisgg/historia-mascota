package com.historia_mascota.persistence.mapper;

import com.historia_mascota.domain.ControlPesoDomain;
import com.historia_mascota.persistence.entity.WeightControlEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", uses = {MascotaMapper.class})
public interface ControlPesoMapper {

    @Mappings({
            @Mapping(source = "idWeightControl", target = "id"),
            @Mapping(source = "dateWeight", target = "fechaControl"),
            @Mapping(source = "hourWeight", target = "horaControl"),
            @Mapping(source = "weight", target = "peso"),
            //@Mapping(source = "vet", target = "veterinario"),
            @Mapping(source = "pet", target = "mascota")
    })
    ControlPesoDomain toControlPeso(WeightControlEntity weightControlEntity);

    List<ControlPesoDomain> toControlPesos(List<WeightControlEntity> weightControls);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "pet", ignore = true)
    })
    WeightControlEntity toWeightControl(ControlPesoDomain controlPesoDomain);
}
