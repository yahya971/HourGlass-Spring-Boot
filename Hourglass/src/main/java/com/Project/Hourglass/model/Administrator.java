package com.Project.Hourglass.model;

import com.Project.Hourglass.model.enumeration.Sex;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Administrator extends Person{

    public Administrator() {
    }

    public Administrator(long id, String name, String lastname, Sex sex, long age, String role, byte[] photo) {
        super(id, name, lastname, sex, age, role,photo);
    }

}
