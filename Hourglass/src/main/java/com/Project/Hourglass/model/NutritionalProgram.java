package com.Project.Hourglass.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "nutritional_program")
@PrimaryKeyJoinColumn(name = "id")
public class NutritionalProgram extends DayProgram {

    @NotNull
    @Column(name = "meals_number", nullable = false)
    private int mealsNumber;

    public NutritionalProgram() {
    }

    public NutritionalProgram(@NotNull LocalDate day, @NotNull String description, @NotNull int mealsNumber) {
        super(day, description);
        this.mealsNumber = mealsNumber;
    }

    public int getMealsNumber() {
        return mealsNumber;
    }

    public void setMealsNumber(int mealsNumber) {
        this.mealsNumber = mealsNumber;
    }

}
