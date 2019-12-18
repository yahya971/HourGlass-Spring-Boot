package com.Project.Hourglass.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "nutritional_program")
@PrimaryKeyJoinColumn(name = "nutritional_program_id")
public class Nutritionalprogram extends Dayprogram {


	@NotNull
    @Column(name = "meals_number", nullable = false)
    private int mealsNumber;
    

    

    
    @ManyToMany(fetch = FetchType.LAZY,
    cascade = {
        CascadeType.PERSIST,
        CascadeType.MERGE
    })
@JoinTable(name = "Meal_Nutritionalprogram",
    joinColumns = { @JoinColumn(name = "nutritional_program_id") },
    inverseJoinColumns = { @JoinColumn(name = "meal_id") })
    private Set<Meal> meals= new HashSet<Meal>();

    public Nutritionalprogram() {
    }

    public Nutritionalprogram(@NotNull int mealsNumber, Set<Meal> meals,String day,String description,Weightlossprogram w) {
        super(day,description,w);
        this.mealsNumber = mealsNumber;
        this.meals = meals;
    }

    public int getMealsNumber() {
        return mealsNumber;
    }

    public void setMealsNumber(int mealsNumber) {
        this.mealsNumber = mealsNumber;
    }

	public Set<Meal> getMeals() {
		return meals;
	}

	public void setMeals(Set<Meal> meals) {
		this.meals = meals;
	}

}
