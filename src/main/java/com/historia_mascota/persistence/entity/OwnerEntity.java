package com.historia_mascota.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "owner")
public class OwnerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Owner")
    private int idOwner;

    @Column(name = "nameOwner")
    private String nameOwner;

    @Column(name = "lastOwner")
    private String lastOwner;

    @Column(name = "ageOwner")
    private int ageOwner;

    @Column(name = "phoneOwner")
    private String phoneOwner;

    //@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //@JsonIgnore
    //private List<PetEntity> pet;

    @OneToMany(mappedBy = "owner")
    private List<PetEntity> pet;
}


/*
package com.historia_mascota.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name="owner")
public class OwnerEntity {

    @Id
    @JsonIgnore
    @Column(name = "id_Owner")
    private int idOwner;

    @Column(name = "nameOwner")
    private String nameOwner;

    @Column(name = "lastOwner")
    private String lastOwner;

    @Column(name = "ageOwner")
    private int ageOwner;

    @Column(name = "phoneOwner")
    private String phoneOwner;

    @OneToMany(mappedBy = "owner")
    @JsonIgnore
    private List<PetEntity> pet;
}


 */