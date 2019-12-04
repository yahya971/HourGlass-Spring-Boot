package com.Project.Hourglass.model;

import com.Project.Hourglass.model.enumeration.Sex;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@PrimaryKeyJoinColumn(name = "admin_id")
public class Administrator extends User {

    public Administrator() {
    }

    public Administrator(@NotBlank @Size(min = 3, max = 50) String username,
                         @NotBlank @Size(max = 50) @Email String email,
                         @NotBlank @Size(min = 3, max = 50) String name,
                         @NotBlank @Size(min = 3, max = 50) String lastname,
                         @NotBlank @Size(min = 6, max = 100) String password) {

        super(username, email, name, lastname, password);
    }
}
