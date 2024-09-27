package com.historia_mascota.persistence.mapper;

import com.historia_mascota.domain.DuenioDomain;
import com.historia_mascota.domain.MascotaDomain;
import com.historia_mascota.domain.VeterinarioDomain;
import com.historia_mascota.persistence.entity.OwnerEntity;
import com.historia_mascota.persistence.entity.PetEntity;
import com.historia_mascota.persistence.entity.VetEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MascotaMapper {

    @Mappings({
            @Mapping(source = "idPet", target = "id"),
            @Mapping(source = "namePet", target = "nombre"),
            @Mapping(source = "typePet", target = "tipoMascota"),
            @Mapping(source = "speciesPet", target = "raza"),
            @Mapping(source = "agePet", target = "edad"),
            @Mapping(source = "genderPet", target = "genero"),
            @Mapping(source = "owner", target = "duenioId", qualifiedByName = "toDuenioWithoutPets"),
            @Mapping(source = "vet", target = "veterinarioId", qualifiedByName = "toVeterinarioWithoutPets"),
            @Mapping(source = "vacunation", target = "vacunacion"),
            @Mapping(source = "weight", target = "controlPeso"),
            @Mapping(source = "deworming", target = "desparacitacion"),
            @Mapping(source = "surgery", target = "cirujia"),
            @Mapping(source = "notification", target = "notificacion")
    })
    MascotaDomain toMascota(PetEntity petEntity);
    List<MascotaDomain> toMascotas(List<PetEntity> pets);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "owner", ignore = true),
            @Mapping(target = "vet", ignore = true),
            @Mapping(target = "vacunation", ignore = true),
            @Mapping(target = "weight", ignore = true),
            @Mapping(target = "deworming", ignore = true),
            @Mapping(target = "surgery", ignore = true),
            @Mapping(target = "notification", ignore = true)
    })
    PetEntity toPet(MascotaDomain mascotaDomain);

    @Named("toDuenioWithoutPets")
    @Mappings({
            @Mapping(target = "pet", ignore = true),
            @Mapping(source = "idOwner", target = "id"),
            @Mapping(source = "nameOwner", target = "name"),
            @Mapping(source = "lastOwner", target = "last"),
            @Mapping(source = "ageOwner", target = "age"),
            @Mapping(source = "phoneOwner", target = "phone")
    })
    DuenioDomain toDuenioWithoutPets(OwnerEntity ownerEntity);

    @Named("toVeterinarioWithoutPets")
    @Mappings({
            @Mapping(target = "mascotas", ignore = true),
            @Mapping(source = "idVet", target = "id"),
            @Mapping(source = "nameVet", target = "nombre"),
            @Mapping(source = "specialtyVet", target = "especialidad"),
            @Mapping(source = "phoneVet", target = "telefono"),
            @Mapping(target = "cirujias", ignore = true),
            @Mapping(target = "desparacitaciones", ignore = true),
            @Mapping(target = "controlPeso", ignore = true)
    })
    VeterinarioDomain toVeterinarioWithoutPets(VetEntity vetEntity);

    /*
    VacunacionDomain vacunationEntityToVacunacionDomain(VacunationEntity vacunationEntity);
    List<VacunacionDomain> vacunationEntityListToVacunacionDomainList(List<VacunationEntity> list);

    ControlPesoDomain weightControlEntityToControlPesoDomain(WeightControlEntity weightControlEntity);
    List<ControlPesoDomain> weightControlEntityListToControlPesoDomainList(List<WeightControlEntity> list);

    DesparacitacionDomain dewormingEntityToDesparacitacionDomain(DewormingEntity dewormingEntity);
    List<DesparacitacionDomain> dewormingEntityListToDesparacitacionDomainList(List<DewormingEntity> list);

    CirujiaDomain surgeryEntityToCirujiaDomain(SurgeryEntity surgeryEntity);
    List<CirujiaDomain> surgeryEntityListToCirujiaDomainList(List<SurgeryEntity> list);

    NotificacionDomain notificationEntityToNotificacionDomain(NotificationEntity notificationEntity);
    List<NotificacionDomain> notificationEntityListToNotificacionDomainList(List<NotificationEntity> list);
     */
}