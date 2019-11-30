package com.Project.Hourglass.model;

import com.Project.Hourglass.model.enumeration.Sex;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotNull;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Coach extends Person {

    @Lob
    @NotNull
    private String resume;

    @NotNull
    private float score;

    public Coach() {
    }

    public Coach(long id, String name, String lastname, Sex sex, long age, byte[] photo, String role, String resume, float score) {
        super(id, name, lastname, sex, age, role,photo);
        this.resume = resume;
        this.score = score;
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
}
