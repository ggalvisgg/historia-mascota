package com.historia_mascota.persistence.mapper;

import com.historia_mascota.domain.TipoCirujiaDomain;
import com.historia_mascota.persistence.entity.TypeSurgeryEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TipoCirujiaMapper {

    @Mappings({
            @Mapping(source = "idTypeSurgery", target = "id"),
            @Mapping(source = "descriptionSu", target = "descripcion")
    })
    TipoCirujiaDomain toTipoCirujia(TypeSurgeryEntity typeSurgeryEntity);

    List<TipoCirujiaDomain> toTipoCirujias(List<TypeSurgeryEntity> TypeSurgerys);

    @InheritInverseConfiguration
    TypeSurgeryEntity toTypeSurgery(TipoCirujiaDomain tipoCirujiaDomain);
}
