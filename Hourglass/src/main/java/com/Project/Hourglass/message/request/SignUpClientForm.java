package com.Project.Hourglass.message.request;

import com.Project.Hourglass.model.enumeration.FatStorage;
import com.Project.Hourglass.model.enumeration.Frame;
import com.Project.Hourglass.model.enumeration.Sex;
import com.Project.Hourglass.model.enumeration.Silhouette;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;

public class SignUpClientForm extends SignUpForm {

    @NotNull
    private long height;

    @NotNull
    private float currentWeight;

    @NotNull
    private float desiredWeight;


    @Enumerated(EnumType.STRING)
    private FatStorage fatDistribution;


    @Enumerated(EnumType.STRING)
    private Frame frame;

    @Enumerated(EnumType.STRING)
    private Silhouette silhouette;

    @Enumerated(EnumType.STRING)
    private Sex sex;

    @NotNull
    private int age;

    @Lob
    private String photo;

    public long getHeight() {
        return height;
    }

    public void setHeight(long height) {
        this.height = height;
    }

    public float getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(float currentWeight) {
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
