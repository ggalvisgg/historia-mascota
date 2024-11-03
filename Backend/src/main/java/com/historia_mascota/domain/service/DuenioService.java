package com.historia_mascota.domain.service;

import com.historia_mascota.domain.DuenioDomain;
import com.historia_mascota.domain.repository.DuenioRepository;
import com.historia_mascota.exceptions.DuenioExistenteException;
import com.historia_mascota.exceptions.UsuarioExistenteException;
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

        if (duenioDomain.getId() == 0) {
            throw new IllegalArgumentException("El ID del dueño no puede ser nulo");
        }

        if (duenioRepository.existeDuenio(duenioDomain.getId())) {
            System.out.println("El dueño con ID " + duenioDomain.getId() + " ya existe.");
            throw new DuenioExistenteException("El dueño ya existe con ID: " + duenioDomain.getId());
        }

        if (userRepository.existsByIdUser(duenioDomain.getId())) {
            System.out.println("El usuario con ID " + duenioDomain.getId() + " ya existe.");
            throw new UsuarioExistenteException("El usuario ya existe con ID: " + duenioDomain.getId());
        }

        DuenioDomain duenio = duenioRepository.guardarDuenio(duenioDomain);

        UserEntity user = new UserEntity();
        user.setIdUser(duenio.getId());
        user.setgetPassword(duenio.getPhone());
        user.setUserType("Owner");
        userRepository.save(user);

        return duenio;
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



