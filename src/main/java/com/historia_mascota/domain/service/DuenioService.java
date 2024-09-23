package com.historia_mascota.domain.service;

import com.historia_mascota.domain.DuenioDomain;
import com.historia_mascota.domain.repository.DuenioRepository;
import com.historia_mascota.persistence.crud.UserCRUDRepository;
import com.historia_mascota.persistence.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DuenioService {

    @Autowired
    private DuenioRepository duenioRepository;

    @Autowired
    private UserCRUDRepository userRepository;

    public List<DuenioDomain> obtenerTodo() {
        return duenioRepository.traerTodosDuenios();
    }

    public Optional<DuenioDomain> obtenerPorId(int id) {
        return duenioRepository.traerPorIdentificacion(id);
    }

    public Optional<List<DuenioDomain>> obtenerPorNombre(String name) {
        return duenioRepository.traerPorNombre(name);
    }

    public DuenioDomain guardarDuenio(DuenioDomain duenioDomain) {

        if(duenioRepository.existeDuenio(duenioDomain.getId())){
            throw new RuntimeException();
        }else {
            if (userRepository.existsByIdUser(duenioDomain.getId())) {
                throw new RuntimeException();
            }
            DuenioDomain duenio = duenioRepository.guardarDuenio(duenioDomain);
            UserEntity user = new UserEntity();
            user.setIdUser(duenio.getId());
            user.setUserType("Owner");
            userRepository.save(user);
            return duenio;
        }
    }

    public boolean eliminarDuenio(int idOwner) {
        return obtenerPorId(idOwner).map(duenio -> {
            duenioRepository.eliminarDuenio(idOwner);
            Optional<UserEntity> user = userRepository.findByIdUser(idOwner);
            user.ifPresent(userRepository::delete);

            return true;
        }).orElse(false);
    }
}



