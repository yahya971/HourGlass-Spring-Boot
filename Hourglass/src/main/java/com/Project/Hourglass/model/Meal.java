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

    private String carbKcal;

    private String energKcal;

    private String fatKcal;

    private String protKcal;

    private String totalWeight;

    private String dietLabels;

    private String healthLabels;

    private String calcium;

    private String carbs;

    private String cholesterol;

    private String fat;

    private String potassium;

    private String magnesium;

    private String protein;

    private String sugar;

    private String vitE;

    private String vitA;

    private String vitB6;

    private String vitD;

    private String vitK;

    private String water;

    @Lob
    private String photo;

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
    
    private Long preparationTime;
    
    
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
            		 CascadeType.MERGE,CascadeType.REFRESH
            },
            mappedBy = "meals")
    @JsonIgnore
    private Set<Nutritionalprogram> nutritionalPrograms=new HashSet<Nutritionalprogram>();

    public Meal() {
    }

    public Meal(String name, @NotNull LocalTime time, String type, String description, float caloricValue,
                String carbKcal, String energKcal, String fatKcal, String protKcal, String totalWeight,
                String dietLabels, String healthLabels, String calcium, String carbs, String cholesterol,
                String fat, String potassium, String magnesium, String protein, String sugar, String vitE,
                String vitA, String vitB6, String vitD, String vitK, String water, String photo,
                @NotNull boolean isTaken, String recipe, String ingredients, Coach coach, Long preparationTime,
                Set<Nutritionalprogram> nutritionalPrograms) {
        this.name = name;
        this.time = time;
        this.type = type;
        this.description = description;
        this.caloricValue = caloricValue;
        this.carbKcal = carbKcal;
        this.energKcal = energKcal;
        this.fatKcal = fatKcal;
        this.protKcal = protKcal;
        this.totalWeight = totalWeight;
        this.dietLabels = dietLabels;
        this.healthLabels = healthLabels;
        this.calcium = calcium;
        this.carbs = carbs;
        this.cholesterol = cholesterol;
        this.fat = fat;
        this.potassium = potassium;
        this.magnesium = magnesium;
        this.protein = protein;
        this.sugar = sugar;
        this.vitE = vitE;
        this.vitA = vitA;
        this.vitB6 = vitB6;
        this.vitD = vitD;
        this.vitK = vitK;
        this.water = water;
        this.photo = photo;
        this.isTaken = isTaken;
        this.recipe = recipe;
        this.ingredients = ingredients;
        this.coach = coach;
        this.preparationTime = preparationTime;
        this.nutritionalPrograms = nutritionalPrograms;
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

    public String getCarbKcal() {
        return carbKcal;
    }

    public void setCarbKcal(String carbKcal) {
        this.carbKcal = carbKcal;
    }

    public String getEnergKcal() {
        return energKcal;
    }

    public void setEnergKcal(String energKcal) {
        this.energKcal = energKcal;
    }

    public String getFatKcal() {
        return fatKcal;
    }

    public void setFatKcal(String fatKcal) {
        this.fatKcal = fatKcal;
    }

    public String getProtKcal() {
        return protKcal;
    }

    public void setProtKcal(String protKcal) {
        this.protKcal = protKcal;
    }

    public String getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(String totalWeight) {
        this.totalWeight = totalWeight;
    }

    public String getDietLabels() {
        return dietLabels;
    }

    public void setDietLabels(String dietLabels) {
        this.dietLabels = dietLabels;
    }

    public String getHealthLabels() {
        return healthLabels;
    }

    public void setHealthLabels(String healthLabels) {
        this.healthLabels = healthLabels;
    }

    public String getCalcium() {
        return calcium;
    }

    public void setCalcium(String calcium) {
        this.calcium = calcium;
    }

    public String getCarbs() {
        return carbs;
    }

    public void setCarbs(String carbs) {
        this.carbs = carbs;
    }

    public String getCholesterol() {
        return cholesterol;
    }

    public void setCholesterol(String cholesterol) {
        this.cholesterol = cholesterol;
    }

    public String getFat() {
        return fat;
    }

    public void setFat(String fat) {
        this.fat = fat;
    }

    public String getPotassium() {
        return potassium;
    }

    public void setPotassium(String potassium) {
        this.potassium = potassium;
    }

    public String getMagnesium() {
        return magnesium;
    }

    public void setMagnesium(String magnesium) {
        this.magnesium = magnesium;
    }

    public String getProtein() {
        return protein;
    }

    public void setProtein(String protein) {
        this.protein = protein;
    }

    public String getSugar() {
        return sugar;
    }

    public void setSugar(String sugar) {
        this.sugar = sugar;
    }

    public String getVitE() {
        return vitE;
    }

    public void setVitE(String vitE) {
        this.vitE = vitE;
    }

    public String getVitA() {
        return vitA;
    }

    public void setVitA(String vitA) {
        this.vitA = vitA;
    }

    public String getVitB6() {
        return vitB6;
    }

    public void setVitB6(String vitB6) {
        this.vitB6 = vitB6;
    }

    public String getVitD() {
        return vitD;
    }

    public void setVitD(String vitD) {
        this.vitD = vitD;
    }

    public String getVitK() {
        return vitK;
    }

    public void setVitK(String vitK) {
        this.vitK = vitK;
    }

    public String getWater() {
        return water;
    }

    public void setWater(String water) {
        this.water = water;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
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


	public Long getPreparationTime() {
		return preparationTime;
	}


	public void setPreparationTime(Long preparationTime) {
		this.preparationTime = preparationTime;
	}
}
