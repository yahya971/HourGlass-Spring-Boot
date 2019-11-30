package com.Project.Hourglass.model;

import com.Project.Hourglass.model.enumeration.FatStorage;
import com.Project.Hourglass.model.enumeration.Frame;
import com.Project.Hourglass.model.enumeration.Sex;
import com.Project.Hourglass.model.enumeration.Silhouette;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotNull;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Client extends Person{

    @NotNull
    private long height;

    @NotNull
    private String currentWeight;

    @NotNull
    private String desiredWeight;

    @NotNull
    @Enumerated(EnumType.STRING)
    private FatStorage fatDistribution;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Frame frame;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Silhouette silhouette;

    public Client() {
    }

    public Client(long id, String name, String lastname, Sex sex, long age, String role, byte[] photo, long height, String currentWeight, String desiredWeight, FatStorage fatDistribution, Frame frame, Silhouette silhouette) {
        super(id, name, lastname, sex, age, role, photo);
        this.height = height;
        this.currentWeight = currentWeight;
        this.desiredWeight = desiredWeight;
        this.fatDistribution = fatDistribution;
        this.frame = frame;
        this.silhouette = silhouette;
    }

    public long getHeight() {
        return height;
    }

    public void setHeight(long height) {
        this.height = height;
    }

    public String getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(String currentWeight) {
        this.currentWeight = currentWeight;
    }

    public String getDesiredWeight() {
        return desiredWeight;
    }

    public void setDesiredWeight(String desiredWeight) {
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
}
