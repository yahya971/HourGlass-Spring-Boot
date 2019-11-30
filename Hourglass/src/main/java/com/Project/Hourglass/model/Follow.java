package com.Project.Hourglass.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;

public class Follow {

    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private long day;

    @NotNull
    private boolean realised;

    @Lob
    @NotNull
    private String comment;

    @NotNull
    private String progression;

    public Follow() {
    }

    public Follow(@NotNull long day, @NotNull boolean realised, @NotNull String comment, @NotNull String progression) {
        this.day = day;
        this.realised = realised;
        this.comment = comment;
        this.progression = progression;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDay() {
        return day;
    }

    public void setDay(long day) {
        this.day = day;
    }

    public boolean isRealised() {
        return realised;
    }

    public void setRealised(boolean realised) {
        this.realised = realised;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getProgression() {
        return progression;
    }

    public void setProgression(String progression) {
        this.progression = progression;
    }
}
