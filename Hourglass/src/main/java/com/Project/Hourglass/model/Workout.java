package com.Project.Hourglass.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.awt.List;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Workout {

    public Workout(long id,String name, @NotNull LocalTime startingHour, @NotNull long duration, String description,
			String equipment, Byte[] photo, float burnedCalories, Coach coach, Set<Sportsprogram> sportsPrograms) {
		super();
		this.id = id;
		this.startingHour = startingHour;
		this.duration = duration;
		this.description = description;
		this.equipment = equipment;
		this.photo = photo;
		this.burnedCalories = burnedCalories;
		this.coach = coach;
		this.sportsPrograms = sportsPrograms;
		this.name=name;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="workout_id")
    private long id;
	
	private String name;

    @NotNull
    @Column(name = "starting_hour", nullable = false)
    private LocalTime startingHour;

    @NotNull
    @Column(name = "duration", nullable = false)
    private long duration;

    @Lob
    private String description;

    @Lob
    private String equipment;
    @Lob
    private String photo;


    private float burnedCalories;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
   	@JoinColumn(name = "coach_id", nullable = false)
    private Coach coach;
    

    
    @JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY,
    cascade = {
        CascadeType.PERSIST,
        CascadeType.MERGE
    },
    mappedBy = "workouts")
    private Set<Sportsprogram> sportsPrograms=new HashSet<Sportsprogram>();

    public Workout() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalTime getStartingHour() {
        return startingHour;
    }

    public void setStartingHour(LocalTime startingHour) {
        this.startingHour = startingHour;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public float getBurnedCalories() {
        return burnedCalories;
    }

    public void setBurnedCalories(float burnedCalories) {
        this.burnedCalories = burnedCalories;
    }

	public Coach getCoach() {
		return coach;
	}

	public void setCoach(Coach coach) {
		this.coach = coach;
	}



	public Set<Sportsprogram> getSportsPrograms() {
		return sportsPrograms;
	}



	public void setSportsPrograms(Set<Sportsprogram> sportsPrograms) {
		this.sportsPrograms = sportsPrograms;
	}



	public String getPhoto() {
		return photo;
	}



	public void setPhoto(String photo) {
		this.photo = photo;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}
}
