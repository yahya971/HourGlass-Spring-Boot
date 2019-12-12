package com.Project.Hourglass.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "nutritional_program")
@PrimaryKeyJoinColumn(name = "nutritional_program_id")
public class Nutritionalprogram extends Dayprogram {

    public Nutritionalprogram(@NotNull int mealsNumber, Set<Meal> meals,LocalDate day,String description) {
		super(day,description);
		this.mealsNumber = mealsNumber;
		this.meals = meals;
	}

	@NotNull
    @Column(name = "meals_number", nullable = false)
    private int mealsNumber;
    

    
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            },
            mappedBy = "nutritionalPrograms")
    private Set<Meal> meals= new HashSet<Meal>();

    public Nutritionalprogram() {
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
