package com.Project.Hourglass.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Meal {

    public Meal(long id, @NotNull LocalTime time, float caloricValue, byte[] photo, @NotNull boolean isTaken,
			String recipe, String ingridentes, Coach coach, Set<Nutritionalprogram> nutritionalPrograms) {
		super();
		this.id = id;
		this.time = time;
		this.caloricValue = caloricValue;
		this.photo = photo;
		this.isTaken = isTaken;
		this.recipe = recipe;
		this.ingridentes = ingridentes;
		this.coach = coach;
		this.nutritionalPrograms = nutritionalPrograms;
	}



	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="meal_id")
    private long id;

    @NotNull
    @Column(nullable = false)
    private LocalTime time;


    private float caloricValue;

    @Lob
    private byte[] photo;

    @NotNull
    @Column(nullable = false)
    private boolean isTaken = false;

    @Lob
    private String recipe;

    @Lob
    private String ingridentes;
    
    @ManyToOne(fetch = FetchType.LAZY)
   	@JoinColumn(name = "coach_id", nullable = false)
    private Coach coach;
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            })
    @JoinTable(name = "Meal_Nutritionalprogram",
            joinColumns = { @JoinColumn(name = "meal_id") },
            inverseJoinColumns = { @JoinColumn(name = "nutritional_program_id") })
    private Set<Nutritionalprogram> nutritionalPrograms=new HashSet<Nutritionalprogram>();

    public Meal() {
    }

  
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public float getCaloricValue() {
        return caloricValue;
    }

    public void setCaloricValue(float caloricValue) {
        this.caloricValue = caloricValue;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public boolean isTaken() {
        return isTaken;
    }

    public void setTaken(boolean taken) {
        isTaken = taken;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public String getIngridentes() {
        return ingridentes;
    }

    public void setIngridentes(String ingridentes) {
        this.ingridentes = ingridentes;
    }

	public Coach getCoach() {
		return coach;
	}

	public void setCoach(Coach coach) {
		this.coach = coach;
	}


	public Set<Nutritionalprogram> getNutritionalPrograms() {
		return nutritionalPrograms;
	}


	public void setNutritionalPrograms(Set<Nutritionalprogram> nutritionalPrograms) {
		this.nutritionalPrograms = nutritionalPrograms;
	}
}
