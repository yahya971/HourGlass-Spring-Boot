package com.Project.Hourglass.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalTime;

@Entity
public class Workout {

    public Workout(long id, @NotNull LocalTime startingHour, @NotNull LocalTime endingHour, String description,
			String equipment, float burnedCalories, Coach coach) {
		super();
		this.id = id;
		this.startingHour = startingHour;
		this.endingHour = endingHour;
		this.description = description;
		this.equipment = equipment;
		this.burnedCalories = burnedCalories;
		this.coach = coach;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="workout_id")
    private long id;

    @NotNull
    @Column(name = "starting_hour", nullable = false)
    private LocalTime startingHour;

    @NotNull
    @Column(name = "ending_hour", nullable = false)
    private LocalTime endingHour;

    @Lob
    private String description;

    @Lob
    private String equipment;


    private float burnedCalories;

    
    @ManyToOne(fetch = FetchType.LAZY)
   	@JoinColumn(name = "coach_id", nullable = false)
    private Coach coach;

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

    public LocalTime getEndingHour() {
        return endingHour;
    }

    public void setEndingHour(LocalTime endingHour) {
        this.endingHour = endingHour;
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
}
