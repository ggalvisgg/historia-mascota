package com.historia_mascota.persistence.mapper;


import com.historia_mascota.domain.dto.OwnerDto;
import com.historia_mascota.persistence.entity.OwnerEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;


//@Mapper(componentModel = "spring")
public interface OwneMapper {

        /*

    @Mappings({
            @Mapping(source = "idOwner", target = "id"),
            @Mapping(source = "nameOwner", target = "name"),
            @Mapping(source = "ageOwner", target = "age"),
            @Mapping(source = "phoneOwner", target = "phone"),
    })
    OwnerDto toOwnerDTO(OwnerEntity ownerEntity);

    @InheritInverseConfiguration
    @Mapping(target = "owners", ignore = true)
    OwnerEntity toOwnerEntity(OwnerDto ownerDto);



    @Mapping(source = "idOwner", target = "id")
    OwnerDto toOwnerDTO(OwnerEntity ownerEntity);

    @Mapping(source = "id", target = "idOwner")
    OwnerEntity toOwnerEntity(OwnerDto ownerDTO);
    */
}
