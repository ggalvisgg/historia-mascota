package com.historia_mascota.domain.service;

import org.springframework.stereotype.Service;
// es la que recibe la orden del controlador que proviene de la
// propia aplicacion o de una aplicación externa.
// servicio le manda al controlador, recibe el objeto o manda dentro
// de la capa del dominio que luego se traduce en una orden a la base de datos(persistencia).
// dirreciona el objeto

@Service
public class OwnerService {
/*
    private final OwnerRepository ownerRepository;

    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public List<OwnerDto> getAll() {
        return ownerRepository.getAll();
    }

    public Optional<OwnerDto> getOwner(int ownerId) {
        return ownerRepository.getOwner(ownerId);
    }

    public OwnerDto save(OwnerDto owner) {
        return ownerRepository.save(owner);
    }

    public boolean delete(int ownerId) {
        return getOwner(ownerId).map(owner -> {
            ownerRepository.delete(ownerId);
            return true;
        }).orElse(false);
    }
 */
}

