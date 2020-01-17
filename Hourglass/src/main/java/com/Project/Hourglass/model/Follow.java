package com.Project.Hourglass.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Follow {

	@NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="follow_id")
    private long follow_id;

    @NotNull
    private String day;

    private String question1;

    private String question2;

    private String question3;

    private String question4;

    private boolean consulted;

    private float weight;

    @Lob
    private String comment;


    @ManyToOne(fetch = FetchType.EAGER)
   	@JoinColumn(name = "weight_loss_program_id", nullable = false)
    private Weightlossprogram weightLossProgram;

    public Follow() {
    }

    public Follow(@NotNull String day, String question1, String question2, String question3, String question4,
                   String comment, float weight, boolean consulted, Weightlossprogram weightLossProgram) {
        this.day = day;
        this.question1 = question1;
        this.question2 = question2;
        this.question3 = question3;
        this.question4 = question4;
        this.consulted = consulted;
        this.comment = comment;
        this.weight = weight;
        this.weightLossProgram = weightLossProgram;
    }

    public long getId() {
        return follow_id;
    }

    public void setId(long id) {
        this.follow_id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

	public Weightlossprogram getWeightLossProgram() {
		return weightLossProgram;
	}

	public void setWeightLossProgram(Weightlossprogram weightLossProgram) {
		this.weightLossProgram = weightLossProgram;
	}

    public String getQuestion1() {
        return question1;
    }

    public void setQuestion1(String question1) {
        this.question1 = question1;
    }

    public String getQuestion2() {
        return question2;
    }

    public void setQuestion2(String question2) {
        this.question2 = question2;
    }

    public String getQuestion3() {
        return question3;
    }

    public void setQuestion3(String question3) {
        this.question3 = question3;
    }

    public String getQuestion4() {
        return question4;
    }

    public void setQuestion4(String question4) {
        this.question4 = question4;
    }

    public boolean isConsulted() {
        return consulted;
    }

    public void setConsulted(boolean consulted) {
        this.consulted = consulted;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}
