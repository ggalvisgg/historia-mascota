package com.historia_mascota.domain.service;

import com.historia_mascota.domain.dto.OwnerDto;
import com.historia_mascota.domain.repository.OwnerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

