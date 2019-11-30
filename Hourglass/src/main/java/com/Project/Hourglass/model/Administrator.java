package com.Project.Hourglass.model;

import javax.persistence.Entity;

@Entity
public class Administrator extends Person{

    public Administrator() {
    }

    public Administrator(long id, String name, String lastname, String sex, long age, String role, byte[] photo) {
        super(id, name, lastname, sex, age, role,photo);
    }

}
