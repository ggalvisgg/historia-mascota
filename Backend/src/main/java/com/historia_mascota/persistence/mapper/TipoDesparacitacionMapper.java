package com.historia_mascota.persistence.mapper;

import com.historia_mascota.domain.DesparacitacionDomain;
import com.historia_mascota.domain.TipoDesparacitacionDomain;
import com.historia_mascota.persistence.entity.TypeDewormingEntity;
import com.historia_mascota.persistence.entity.DewormingEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TipoDesparacitacionMapper {

    @Mappings({
            @Mapping(source = "idTypeDeworming", target = "id"),
            @Mapping(source = "description", target = "descripcion")
    })
    TipoDesparacitacionDomain toTipoDesparacitacion(TypeDewormingEntity typeDewormingEntity);

    List<TipoDesparacitacionDomain> toTipoDesparacitaciones(List<TypeDewormingEntity> typeDewormings);

    @InheritInverseConfiguration
    TypeDewormingEntity toTypeDeworming(TipoDesparacitacionDomain tipoDesparacitacionDomain);

    @Named("toDesparacitacionWithoutTypeDeworming")
    @Mappings({
            @Mapping(target = "pet", ignore = true),
            @Mapping(target = "vet", ignore = true),
            @Mapping(source = "id", target = "idDeworming"),
            @Mapping(source = "fecha", target = "dateDeworming")
    })
    DewormingEntity toDesparacitacionWithoutTypeDeworming(DesparacitacionDomain desparacitacionDomain);
}
