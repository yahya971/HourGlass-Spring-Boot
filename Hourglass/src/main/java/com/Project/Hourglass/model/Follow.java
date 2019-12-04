package com.Project.Hourglass.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Follow {

    public Follow(@NotNull long id, @NotNull long day, @NotNull boolean realised, @NotNull String comment,
			@NotNull String progression, Weightlossprogram weightLossProgram) {
		super();
		this.follow_id = id;
		this.day = day;
		this.realised = realised;
		this.comment = comment;
		this.progression = progression;
		this.weightLossProgram = weightLossProgram;
	}

	@NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="follow_id")
    private long follow_id;

    @NotNull
    private long day;

    @NotNull
    private boolean realised;

    @Lob
    @NotNull
    private String comment;

    @NotNull
    private String progression;
    
    
    @ManyToOne(fetch = FetchType.LAZY)
   	@JoinColumn(name = "weight_loss_program_id", nullable = false)
    private Weightlossprogram weightLossProgram;

    public Follow() {
    }

    public long getId() {
        return follow_id;
    }

    public void setId(long id) {
        this.follow_id = id;
    }

    public long getDay() {
        return day;
    }

    public void setDay(long day) {
        this.day = day;
    }

    public boolean isRealised() {
        return realised;
    }

    public void setRealised(boolean realised) {
        this.realised = realised;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getProgression() {
        return progression;
    }

    public void setProgression(String progression) {
        this.progression = progression;
    }

	public Weightlossprogram getWeightLossProgram() {
		return weightLossProgram;
	}

	public void setWeightLossProgram(Weightlossprogram weightLossProgram) {
		this.weightLossProgram = weightLossProgram;
	}
}
