package com.historia_mascota.persistence.mapper;

import com.historia_mascota.domain.DuenioDomain;
import com.historia_mascota.persistence.entity.OwnerEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
import java.util.Optional;

//verificar el mapper, falta una parte
@Mapper(componentModel = "spring")
public interface DuenioMapper {

    @Mappings({
            @Mapping(source = "idOwner", target = "id"),
            @Mapping(source = "nameOwner", target = "name"),
            @Mapping(source = "ageOwner", target = "age"),
            @Mapping(source = "phoneOwner", target = "phone"),
            @Mapping(source = "pet", target = "pet"),
    })
    DuenioDomain toDuenio(OwnerEntity ownerEntity);
    List<DuenioDomain> toDuenios(List<OwnerEntity> owners);

    @InheritInverseConfiguration
    OwnerEntity toOwner(DuenioDomain duenioDomain);
}
