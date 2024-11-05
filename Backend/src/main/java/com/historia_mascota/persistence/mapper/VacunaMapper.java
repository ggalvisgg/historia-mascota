package com.historia_mascota.persistence.mapper;

import com.historia_mascota.domain.VacunaDomain;
import com.historia_mascota.persistence.entity.VaccineEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", uses = {TipoVacunaMapper.class})
public interface VacunaMapper {
    @Mappings({
            @Mapping(source = "idVaccine", target = "id"),
            @Mapping(source = "nameVaccine", target = "nombreVacuna"),
            @Mapping(source = "descriptionVaccine", target = "descripcionVacuna"),
            @Mapping(source = "producerVaccine", target = "productorVacuna"),
            @Mapping(source = "expirationDate", target = "fechaExpiracion"),
            @Mapping(source = "cantVaccine", target = "cantidad"),
            @Mapping(source = "typeVaccine", target = "tipo")
    })
    VacunaDomain toVacuna(VaccineEntity vaccineEntity);

    List<VacunaDomain> toVacunas(List<VaccineEntity> vaccines);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "typeVaccine", ignore = true)
    })
    VaccineEntity toVaccine(VacunaDomain vacuna);
}
