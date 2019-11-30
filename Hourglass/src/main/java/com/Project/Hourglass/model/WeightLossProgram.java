package com.Project.Hourglass.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "weight_loss_program")
public class WeightLossProgram {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Lob
    @Column(name = "description", nullable = false)
    private String description;

    @NotNull
    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @NotNull
    @Column(name = "duration", nullable = false)
    private int duration;

    private float rating;

    @Lob
    @Column(name = "background_image")
    private byte[] backgroundImage;

    @Lob
    private String objectifs;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public byte[] getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(byte[] backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public String getObjectifs() {
        return objectifs;
    }

    public void setObjectifs(String objectifs) {
        this.objectifs = objectifs;
    }
}
