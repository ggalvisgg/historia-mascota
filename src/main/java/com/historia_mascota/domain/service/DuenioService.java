package com.historia_mascota.domain.service;

import com.historia_mascota.domain.DuenioDomain;
import com.historia_mascota.domain.repository.DuenioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DuenioService {

    @Autowired
    private DuenioRepository duenioRepository;

    public List<DuenioDomain> getAll() {
        return duenioRepository.getAll();
    }

    public Optional<DuenioDomain> getOwner(int idOwner) {
        return duenioRepository.getOwner(idOwner);
    }

    public Optional<List<DuenioDomain>> getByName(String nameOwner) {
        return duenioRepository.getByName(nameOwner);
    }

    public DuenioDomain save(DuenioDomain duenioDomain) {
        return duenioRepository.save(duenioDomain);
    }

    public boolean delete(int idOwner) {
        return getOwner(idOwner).map(product -> {
            duenioRepository.delete(idOwner);
            return true;
        }).orElse(false);
    }

}



