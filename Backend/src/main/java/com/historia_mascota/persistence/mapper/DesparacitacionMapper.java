package com.historia_mascota.persistence.mapper;

import com.historia_mascota.domain.DesparacitacionDomain;
import com.historia_mascota.persistence.entity.DewormingEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", uses = {MascotaMapper.class})
public interface DesparacitacionMapper {
    @Mappings({
            @Mapping(source = "idDeworming", target = "id"),
            @Mapping(source = "dateDeworming", target = "fecha"),
            @Mapping(source = "type", target = "tipoDesparacitacion"),
            @Mapping(source = "batchControl", target = "lote"),
            @Mapping(source = "boosterControl", target = "refuerzo"),
            //@Mapping(source = "vet", target = "veterinario"),
            //@Mapping(source = "typeDeworming", target = "tipo"),
            @Mapping(source = "pet", target = "mascota")
    })
    DesparacitacionDomain toDesparacitacion(DewormingEntity dewormingEntity);

    List<DesparacitacionDomain> toDesparacitaciones(List<DewormingEntity> dewormings);

    @InheritInverseConfiguration

    @Mappings({
            @Mapping(target = "pet", ignore = true)
            //@Mapping(target = "vet", ignore = true)
    })
    DewormingEntity toDeworming(DesparacitacionDomain desparacitacionDomain);
}
