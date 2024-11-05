package com.historia_mascota.persistence.mapper;

import com.historia_mascota.domain.TipoVacunaDomain;
import com.historia_mascota.persistence.entity.TypeVaccineEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TipoVacunaMapper {

    @Mappings({
            @Mapping(source = "idTypeVaccine", target = "id"),
            @Mapping(source = "descriptionVaccine", target = "descripcion"),
            @Mapping(source = "typeVaccine", target = "vacuna")

    })
    TipoVacunaDomain toTipoVacuna(TypeVaccineEntity typeVaccineEntity);

    List<TipoVacunaDomain> toTipoVacunas(List<TypeVaccineEntity> typeVaccines);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "typeVaccine", ignore = true)
    })
    TypeVaccineEntity toTypeVaccine(TipoVacunaDomain tipoVacunaDomain);


}
