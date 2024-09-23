package com.historia_mascota.domain.service;

import com.historia_mascota.domain.DuenioDomain;
import com.historia_mascota.domain.VeterinarioDomain;
import com.historia_mascota.domain.repository.VeterinarioRepository;
import com.historia_mascota.persistence.crud.UserCRUDRepository;
import com.historia_mascota.persistence.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class VeterinarioService {

    @Autowired
    private VeterinarioRepository veterinarioRepository;

    @Autowired
    private UserCRUDRepository userRepository;

    public List<VeterinarioDomain> obtenerTodo() {
        return veterinarioRepository.traerTodosVeterinarios();
    }

    public Optional<VeterinarioDomain> obtenerPorId(int id) {
        return veterinarioRepository.traerPorIdentificacion(id);
    }

    public Optional<List<VeterinarioDomain>> obtenerPorNombre(String name) {
        return veterinarioRepository.traerPorNombre(name);
    }

    public Optional<List<VeterinarioDomain>> obtenerPorEspecialidad(String especialidad) {
        return veterinarioRepository.traerPorEspecialidad(especialidad);
    }

    public VeterinarioDomain guardarVeterinario(VeterinarioDomain veterinarioDomain) {

        if(veterinarioRepository.existeVet(veterinarioDomain.getId())){
            //throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error: El veterinario con ID " + veterinarioDomain.getId() + " ya está registrado.");
            throw new RuntimeException();
        }else {
            if (userRepository.existsByIdUser(veterinarioDomain.getId())) {
                throw new RuntimeException();
                //throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error: El id " + veterinarioDomain.getId() + " ya está registrado con otro usuario.");
            }
            VeterinarioDomain veterinario = veterinarioRepository.guardarVeterinario(veterinarioDomain);
            UserEntity user = new UserEntity();
            user.setIdUser(veterinario.getId());
            user.setUserType("Vet");
            userRepository.save(user);
            return veterinario;
        }
    }

    public boolean eliminarVeterinario(int idVet) {
        return obtenerPorId(idVet).map(veterinario -> {
            veterinarioRepository.eliminarVeterinario(idVet);
            Optional<UserEntity> user = userRepository.findByIdUser(idVet);
            user.ifPresent(userRepository::delete);

            return true;
        }).orElse(false);
    }
}
