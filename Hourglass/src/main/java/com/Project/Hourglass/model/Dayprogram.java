package com.Project.Hourglass.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;

@Entity
@Table(name = "day_program")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Dayprogram {

	
    @Id
    @Column(name="day_program_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "day", nullable = false)
    private String day;

    @NotNull
    @Lob
    @Column(nullable = false)
    private String description;
    
    


    public Dayprogram() {
    }

    public Dayprogram(@NotNull String day, @NotNull String description) {
        this.day = day;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
