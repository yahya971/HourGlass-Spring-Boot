package com.Project.Hourglass.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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


	public Sportsprogram(Set<Workout> workouts,String day,String description,Weightlossprogram w,String name) {
		super(day,description,name,w);
		this.workouts = workouts;
	}

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
            		CascadeType.MERGE,CascadeType.REFRESH,
                
            })
    @JoinTable(name = "workout_sportsprogram",
            joinColumns = { @JoinColumn(name = "sport_program_id") },
            inverseJoinColumns = { @JoinColumn(name = "workout_id") })
    private Set<Workout> workouts= new HashSet<Workout>();
    public Sportsprogram() {
    }

    public Sportsprogram(@NotNull String day, @NotNull String description,Set<Workout> workouts,Weightlossprogram w,String name) {
        super(name, day,description,w);
        this.workouts = workouts;
    }

	public Set<Workout> getWorkouts() {
		return workouts;
	}

	public void setWorkouts(Set<Workout> workouts) {
		this.workouts = workouts;
	}
}
