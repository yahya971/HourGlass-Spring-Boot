package com.Project.Hourglass.model;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class Client extends Person{

    @NotNull
    private long height;

    @NotNull
    private String currentWeight;

    @NotNull
    private String desiredWeight;

    @NotNull
    private String fatDistribution;

    @NotNull
    private String frame;

    @NotNull
    private String silhouette;

    public Client() {
    }

    public Client(long id, String name, String lastname, String sex, long age, String role, byte[] photo, long height, String currentWeight, String desiredWeight, String fatDistribution, String frame, String silhouette) {
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

    public String getFatDistribution() {
        return fatDistribution;
    }

    public void setFatDistribution(String fatDistribution) {
        this.fatDistribution = fatDistribution;
    }

    public String getFrame() {
        return frame;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }

    public String getSilhouette() {
        return silhouette;
    }

    public void setSilhouette(String silhouette) {
        this.silhouette = silhouette;
    }
}
