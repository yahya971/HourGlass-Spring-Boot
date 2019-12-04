package com.Project.Hourglass.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "nutritional_program")
@PrimaryKeyJoinColumn(name = "nutritional_program_id")
public class Nutritionalprogram extends Dayprogram {

    @NotNull
    @Column(name = "meals_number", nullable = false)
    private int mealsNumber;

    public Nutritionalprogram() {
    }

    public Nutritionalprogram(@NotNull LocalDate day, @NotNull String description, @NotNull int mealsNumber) {
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
