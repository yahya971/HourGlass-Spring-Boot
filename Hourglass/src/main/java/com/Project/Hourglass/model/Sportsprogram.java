package com.Project.Hourglass.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "sports_program")
@PrimaryKeyJoinColumn(name = "id")
public class Sportsprogram extends Dayprogram {

    public Sportsprogram() {
    }

    public Sportsprogram(@NotNull LocalDate day, @NotNull String description) {
        super(day, description);
    }
}
