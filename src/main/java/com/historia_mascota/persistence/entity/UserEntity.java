package com.historia_mascota.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @Column(name = "id_User")
    private Integer idUser;

    @Column(name = "user_type")
    private String userType;
}




