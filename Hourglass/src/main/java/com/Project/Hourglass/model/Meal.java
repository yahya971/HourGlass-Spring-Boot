package com.Project.Hourglass.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.springframework.boot.jackson.JsonComponent;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity
@JsonComponent
public class Meal {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="meal_id")
    private long id;
	private String name;
    @NotNull
    @Column(nullable = false)
    private LocalTime time;

    private String type;
    private String description;
    
    private float caloricValue;

    @Lob
    private byte[] photo;

    @NotNull
    @Column(nullable = false)
    private boolean isTaken = false;

    @Lob
    private String recipe;

    @Lob
    private String ingredients;
    
    @ManyToOne(fetch = FetchType.LAZY)
   	@JoinColumn(name = "coach_id", nullable = false)
	@JsonIgnore
    private Coach coach;
    
    
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.MERGE,
                CascadeType.PERSIST
            },
            mappedBy = "meals")
    @JsonIgnore
    private Set<Nutritionalprogram> nutritionalPrograms=new HashSet<Nutritionalprogram>();

    public Meal() {
    }

    public Meal(long id,String name, @NotNull LocalTime time, String type, String description, float caloricValue, byte[] photo,
                @NotNull boolean isTaken, String recipe, String ingredients, Coach coach,
                Set<Nutritionalprogram> nutritionalPrograms) {
        super();
        this.id = id;
        this.time = time;
        this.type = type;
        this.description = description;
        this.caloricValue = caloricValue;
        this.photo = photo;
        this.isTaken = isTaken;
        this.recipe = recipe;
        this.ingredients = ingredients;
        this.coach = coach;
        this.nutritionalPrograms = nutritionalPrograms;
        this.name=name;
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

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
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


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
}
