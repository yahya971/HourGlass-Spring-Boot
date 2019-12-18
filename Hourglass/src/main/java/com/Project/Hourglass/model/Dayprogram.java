package com.Project.Hourglass.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;
import java.util.ArrayList;

@Entity
@Table(name = "day_program")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Dayprogram {

	
    public Dayprogram( @NotNull String day, @NotNull String description, Weightlossprogram weightLossProgram) {
		super();
		
		this.day = day;
		this.description = description;
		this.weightlossprogram = weightLossProgram;
	}

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
    
    
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
   	@JoinColumn(name = "weight_loss_program_id", nullable = false)
    private Weightlossprogram weightlossprogram;
    
    


    public Dayprogram() {
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
    @JsonIgnore
	public Weightlossprogram getWeightLossProgram() {
		return weightlossprogram;
	}
    
	public void setWeightLossProgram(Weightlossprogram weightLossProgram) {
		this.weightlossprogram = weightLossProgram;
	}


}
