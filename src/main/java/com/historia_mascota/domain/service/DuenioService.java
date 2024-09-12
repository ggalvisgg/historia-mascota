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

    public List<DuenioDomain> findAll() {
        return duenioRepository.findAll();
    }

    public Optional<DuenioDomain> findById(int id) {
        return duenioRepository.findById(id);
    }

    public Optional<List<DuenioDomain>> findByNameOwner(String name) {
        return duenioRepository.findByNameOwner(name);
    }

    public DuenioDomain save(DuenioDomain duenioDomain) {
        return duenioRepository.save(duenioDomain);
    }

    public boolean delete(int id) {
        return findById(id).map(product -> {
            duenioRepository.delete(id);
            return true;
        }).orElse(false);
    }

}



