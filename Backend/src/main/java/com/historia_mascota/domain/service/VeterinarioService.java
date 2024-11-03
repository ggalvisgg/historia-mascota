package com.historia_mascota.domain.service;

import com.historia_mascota.domain.VeterinarioDomain;
import com.historia_mascota.domain.repository.VeterinarioRepository;
import com.historia_mascota.exceptions.UsuarioExistenteException;
import com.historia_mascota.exceptions.VeterinarioExistenteException;
import com.historia_mascota.persistence.crud.UserCRUDRepository;
import com.historia_mascota.persistence.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        if (veterinarioDomain.getId() == 0) {
            throw new IllegalArgumentException("El ID del veterinario no puede ser nulo");
        }

        if (veterinarioRepository.existeVet(veterinarioDomain.getId())) {
            System.out.println("El veterinario con ID " + veterinarioDomain.getId() + " ya existe.");
            throw new VeterinarioExistenteException("El veterinario ya existe con ID: " + veterinarioDomain.getId());
        }

        if (userRepository.existsByIdUser(veterinarioDomain.getId())) {
            System.out.println("El usuario con ID " + veterinarioDomain.getId() + " ya existe.");
            throw new UsuarioExistenteException("El usuario ya existe con ID: " + veterinarioDomain.getId());
        }

        VeterinarioDomain veterinario = veterinarioRepository.guardarVeterinario(veterinarioDomain);

        UserEntity user = new UserEntity();
        user.setIdUser(veterinario.getId());
        user.setgetPassword(veterinario.getTelefono());
        user.setUserType("Vet");
        userRepository.save(user);

        return veterinario;
    }

    /*
    public VeterinarioDomain guardarVeterinario(VeterinarioDomain veterinarioDomain) {

        if(veterinarioRepository.existeVet(veterinarioDomain.getId())){
            System.out.println("existeeeeeeee el veterinario");
            throw new RuntimeException();
        }else {
            if (userRepository.existsByIdUser(veterinarioDomain.getId())) {
                System.out.println("existeeeeeeee el usuariooooo");
                throw new RuntimeException();
            }
            VeterinarioDomain veterinario = veterinarioRepository.guardarVeterinario(veterinarioDomain);
            UserEntity user = new UserEntity();
            user.setIdUser(veterinario.getId());
            user.setUserType("Vet");
            userRepository.save(user);
            return veterinario;
        }
    }

     */

    public boolean eliminarVeterinario(int idVet) {
        return obtenerPorId(idVet).map(veterinario -> {
            veterinarioRepository.eliminarVeterinario(idVet);
            Optional<UserEntity> user = userRepository.findByIdUser(idVet);
            user.ifPresent(userRepository::delete);

            return true;
        }).orElse(false);
    }
}
