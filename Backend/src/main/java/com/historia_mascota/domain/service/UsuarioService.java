package com.historia_mascota.domain.service;

import com.historia_mascota.domain.DuenioDomain;
import com.historia_mascota.persistence.crud.UserCRUDRepository;
import com.historia_mascota.persistence.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UserCRUDRepository userRepository;

    public List<UserEntity> obtenerTodo() {
        return userRepository.findAll();
    }
}
