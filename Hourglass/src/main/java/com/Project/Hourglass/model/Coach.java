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

    private float score1;

    private float score2;

    private float score3;

    private float score4;

    private int age;

    @Lob
    private String photo;

    @NotNull
    private int experience;

    @NotBlank
    private String speciality;

    @NotBlank
    private String phone;
    
    public Coach() {
    }

    public Coach(@NotBlank @Size(min = 3, max = 50) String username, @NotBlank @Size(max = 50) @Email String email,
                 @NotBlank @Size(min = 3, max = 50) String name, @NotBlank @Size(min = 3, max = 50) String lastname,
                 @NotBlank @Size(min = 6, max = 100) String password, @NotEmpty String resume,
                 float score1, float score2,float score3, float socre4, int age,
                 String photo,@NotEmpty int experience,@NotEmpty String speciality,@NotEmpty String phone ) {

        super(username, email, name, lastname, password);
        this.resume = resume;
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
        this.score4 = score4;
        this.age = age;
        this.photo = photo;
        this.experience = experience;
        this.speciality = speciality;
        this.phone = phone;
    }

    public String getResume() {

        return resume;
    }

    public void setResume(String resume) {

        this.resume = resume;
    }

    public float getScore1() {
        return score1;
    }

    public void setScore1(float score1) {
        this.score1 = score1;
    }

    public float getScore2() {
        return score2;
    }

    public void setScore2(float score2) {
        this.score2 = score2;
    }

    public float getScore3() {
        return score3;
    }

    public void setScore3(float score3) {
        this.score3 = score3;
    }

    public float getScore4() {
        return score4;
    }

    public void setScore4(float score4) {
        this.score4 = score4;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
