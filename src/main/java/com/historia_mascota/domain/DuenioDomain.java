package com.historia_mascota.domain;

import com.historia_mascota.domain.dto.PetDto;

import java.util.List;

public class DuenioDomain {

    private int id;
    private String name;
    private String last;
    private int age;
    private String phone;
    private List<MascotaDomain> pet;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<MascotaDomain> getPet() {
        return pet;
    }

    public void setPet(List<MascotaDomain> pet) {
        this.pet = pet;
    }
}



