package com.Project.Hourglass.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "sports_program")
@PrimaryKeyJoinColumn(name = "sport_program_id")
public class Sportsprogram extends Dayprogram {


	public Sportsprogram(Set<Workout> workouts,LocalDate day,String description) {
		super(day,description);
		this.workouts = workouts;
	}

	@ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            },
            mappedBy = "sportsPrograms")
    private Set<Workout> workouts= new HashSet<Workout>();
    public Sportsprogram() {
    }

    public Sportsprogram(@NotNull LocalDate day, @NotNull String description,Set<Workout> workouts) {
        super(day, description);
        this.workouts = workouts;
    }

	public Set<Workout> getWorkouts() {
		return workouts;
	}

	public void setWorkouts(Set<Workout> workouts) {
		this.workouts = workouts;
	}
}
