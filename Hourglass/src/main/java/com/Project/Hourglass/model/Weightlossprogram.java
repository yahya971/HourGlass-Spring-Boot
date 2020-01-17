package com.Project.Hourglass.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "weight_loss_program")

public class Weightlossprogram {


    public Weightlossprogram( @NotNull String description, @NotNull LocalDate startDate, @NotNull int duration, float price,
			float rating, String backgroundImage, String objectifs, Client client, Coach coach, Audiance audiance, @NotBlank String name) {
		super();

		this.description = description;
		this.endDate = startDate;
		this.duration = duration;
		this.rating = rating;
		this.backgroundImage = backgroundImage;
		this.objectifs = objectifs;
		this.client = client;
		this.coach = coach;
		this.audiance = audiance;
		this.name = name;
		this.price = price;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="weightlossprogram_id")
    private long id;

    @NotNull
    @Lob
    @Column(name = "description", nullable = false)
    private String description;

    
    @Column(name = "end_date", nullable = true)
    private LocalDate endDate;

    @NotNull
    @Column(name = "duration", nullable = false)
    private int duration;

    private float rating;

    @Lob
    @Column(name = "background_image")
    private String backgroundImage;

    @Lob
    private String objectifs;
    
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "client_id", nullable = true)
    private Client client;
    
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "coach_id", nullable = false)
    private Coach coach;
    
    @OneToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinColumn(name = "audiance_id")

    @JsonIgnore
    private Audiance audiance;

    
    @NotBlank
    private String name;

    private float price;
    
    
    
    public Weightlossprogram() {
    }

    public Weightlossprogram(long id, @NotNull String description, @NotNull LocalDate startDate, @NotNull int duration,
                             float rating, String backgroundImage, String objectifs, Client client, Coach coach, Audiance audiance) {
        super();
        this.id = id;
        this.description = description;
        this.endDate = startDate;
        this.duration = duration;
        this.rating = rating;
        this.backgroundImage = backgroundImage;
        this.objectifs = objectifs;
        this.client = client;
        this.coach = coach;
        this.audiance = audiance;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate startDate) {
        this.endDate = startDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(String backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public String getObjectifs() {
        return objectifs;
    }

    public void setObjectifs(String objectifs) {
        this.objectifs = objectifs;
    }

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Coach getCoach() {
		return coach;
	}

	public void setCoach(Coach coach) {
		this.coach = coach;
	}

	public Audiance getAudiance() {
		return audiance;
	}

	public void setAudiance(Audiance audiance) {
		this.audiance = audiance;
	}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
