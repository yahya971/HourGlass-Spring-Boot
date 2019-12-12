package com.Project.Hourglass.model;

import com.Project.Hourglass.model.enumeration.Sex;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.*;

import org.springframework.boot.jackson.JsonComponent;

@Entity
@PrimaryKeyJoinColumn(name = "coach_id")
@JsonComponent
public class Coach extends User {

    @Lob
    @NotEmpty
    private String resume;

    private float score;

    private int age;

    @Lob
    private byte[] photo;

    public Coach() {
    }

    public Coach(@NotBlank @Size(min = 3, max = 50) String username, @NotBlank @Size(max = 50) @Email String email,
                 @NotBlank @Size(min = 3, max = 50) String name, @NotBlank @Size(min = 3, max = 50) String lastname,
                 @NotBlank @Size(min = 6, max = 100) String password, @NotEmpty String resume,
                 float score, int age, byte[] photo) {

        super(username, email, name, lastname, password);
        this.resume = resume;
        this.score = score;
        this.age = age;
        this.photo = photo;
    }

    public String getResume() {

        return resume;
    }

    public void setResume(String resume) {

        this.resume = resume;
    }

    public float getScore() {

        return score;
    }

    public void setScore(float score) {

        this.score = score;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
}
