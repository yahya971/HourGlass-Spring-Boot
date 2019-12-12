package com.Project.Hourglass.model;

import com.Project.Hourglass.model.enumeration.FatStorage;
import com.Project.Hourglass.model.enumeration.Frame;
import com.Project.Hourglass.model.enumeration.Sex;
import com.Project.Hourglass.model.enumeration.Silhouette;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@PrimaryKeyJoinColumn(name = "client_id")
public class Client extends User {

    @NotNull
    private long height;

    @NotNull
    private float currentWeight;

    @NotNull
    private float desiredWeight;

    //@NotEmpty
    @Enumerated(EnumType.STRING)
    private FatStorage fatDistribution;

    //@NotEmpty
    @Enumerated(EnumType.STRING)
    private Frame frame;

    //@NotEmpty
    @Enumerated(EnumType.STRING)
    private Silhouette silhouette;

    //@NotEmpty
    @Enumerated(EnumType.STRING)
    private Sex sex;

    @NotNull
    private int age;

    @Lob
    private byte[] photo;
    

    public Client() {
    }

    public Client(@NotBlank @Size(min = 3, max = 50) String username, @NotBlank @Size(max = 50) @Email String email,
                  @NotBlank @Size(min = 3, max = 50) String name, @NotBlank @Size(min = 3, max = 50) String lastname,
                  @NotBlank @Size(min = 6, max = 100) String password, @NotEmpty long height, @NotEmpty float currentWeight,
                  @NotEmpty float desiredWeight, @NotEmpty FatStorage fatDistribution, @NotEmpty Frame frame,
                  @NotEmpty Silhouette silhouette, @NotEmpty Sex sex, @NotBlank int age, byte[] photo) {

        super(username, email, name, lastname, password);
        this.height = height;
        this.currentWeight = currentWeight;
        this.desiredWeight = desiredWeight;
        this.fatDistribution = fatDistribution;
        this.frame = frame;
        this.silhouette = silhouette;
        this.sex = sex;
        this.age = age;
        this.photo = photo;
    }

    public long getHeight() {

        return height;
    }

    public void setHeight(long height)
    {
        this.height = height;
    }

    public float getCurrentWeight() {

        return currentWeight;
    }

    public void setCurrentWeight(float currentWeight)
    {
        this.currentWeight = currentWeight;
    }

    public float getDesiredWeight() {

        return desiredWeight;
    }

    public void setDesiredWeight(float desiredWeight) {

        this.desiredWeight = desiredWeight;
    }

    public FatStorage getFatDistribution() {

        return fatDistribution;
    }

    public void setFatDistribution(FatStorage fatDistribution) {

        this.fatDistribution = fatDistribution;
    }

    public Frame getFrame() {

        return frame;
    }

    public void setFrame(Frame frame) {

        this.frame = frame;
    }

    public Silhouette getSilhouette() {
        return silhouette;
    }

    public void setSilhouette(Silhouette silhouette) {
        this.silhouette = silhouette;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
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
