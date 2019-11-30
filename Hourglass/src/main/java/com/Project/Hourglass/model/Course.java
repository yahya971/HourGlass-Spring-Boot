package com.Project.Hourglass.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Course {


    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;

    @NotNull
    private String name;

    @Lob
    @NotNull
    private String description;

    @Lob
    @NotNull
    private byte[] backGroundImage;

    @NotNull
    private float price;

    //lezem nzidou les videos eli fel Course ama ma3raftech kifech nestockihom eli 3andou fekra iguedha

    public Course() {
    }

    public Course(@NotNull String name, @NotNull String description, @NotNull byte[] backGroundImage, @NotNull float price) {
        this.name = name;
        this.description = description;
        this.backGroundImage = backGroundImage;
        this.price = price;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getNom() {
        return name;
    }

    public void setNom(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getBackGroundImage() {
        return backGroundImage;
    }

    public void setBackGroundImage(byte[] backGroundImage) {
        this.backGroundImage = backGroundImage;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
