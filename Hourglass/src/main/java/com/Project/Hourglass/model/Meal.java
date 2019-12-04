package com.Project.Hourglass.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalTime;

@Entity
public class Meal {

    public Meal(long id, @NotNull LocalTime time, float caloricValue, byte[] photo, @NotNull boolean isTaken,
			String recipe, String ingridentes, Coach coach) {
		super();
		this.id = id;
		this.time = time;
		this.caloricValue = caloricValue;
		this.photo = photo;
		this.isTaken = isTaken;
		this.recipe = recipe;
		this.ingridentes = ingridentes;
		this.coach = coach;
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
}
