package com.Project.Hourglass.model;

import com.Project.Hourglass.model.enumeration.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Audiance {

    public Audiance(long id, @NotNull Sex sex, @NotNull float height, @NotNull float objectiveWeight,
			@NotNull Frame frame, @NotNull FatStorage fatStorage, @NotNull Silhouette silhouette,
			@NotNull OverweightCause overweightCause, Weightlossprogram weightLossProgram) {
		super();
		this.id = id;
		this.sex = sex;
		this.height = height;
		this.objectiveWeight = objectiveWeight;
		this.frame = frame;
		this.fatStorage = fatStorage;
		this.silhouette = silhouette;
		this.overweightCause = overweightCause;
		this.weightLossProgram = weightLossProgram;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="audiance_id")
    private long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Sex sex;

    @NotNull
    @Column(nullable = false)
    private float height;

    @NotNull
    @Column(nullable = false)
    private float objectiveWeight;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Frame frame;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FatStorage fatStorage;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Silhouette silhouette;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OverweightCause overweightCause;
    
    @OneToOne(mappedBy = "audiance",fetch = FetchType.LAZY)
    private Weightlossprogram weightLossProgram;
    

    public Audiance() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getObjectiveWeight() {
        return objectiveWeight;
    }

    public void setObjectiveWeight(float objectiveWeight) {
        this.objectiveWeight = objectiveWeight;
    }

    public Frame getFrame() {
        return frame;
    }

    public void setFrame(Frame frame) {
        this.frame = frame;
    }

    public FatStorage getFatStorage() {
        return fatStorage;
    }

    public void setFatStorage(FatStorage fatStorage) {
        this.fatStorage = fatStorage;
    }

    public Silhouette getSilhouette() {
        return silhouette;
    }

    public void setSilhouette(Silhouette silhouette) {
        this.silhouette = silhouette;
    }

    public OverweightCause getOverweightCause() {
        return overweightCause;
    }

    public void setOverweightCause(OverweightCause overweightCause) {
        this.overweightCause = overweightCause;
    }

	public Weightlossprogram getWeightLossProgram() {
		return weightLossProgram;
	}

	public void setWeightLossProgram(Weightlossprogram weightLossProgram) {
		this.weightLossProgram = weightLossProgram;
	}
}
