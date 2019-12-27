package com.Project.Hourglass.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Course {

	@NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="course_id")
    private long id;

    @NotNull
    private String name;

    @Lob
    @NotNull
    private String description;

    @Lob
    private String backGroundImage;

    @NotNull
    private float price;
    
    @ManyToOne(fetch = FetchType.LAZY)
   	@JoinColumn(name = "coach_id")
    private Coach coach;
    
    @ManyToOne(fetch = FetchType.LAZY)
   	@JoinColumn(name = "client_id")
    private Client client;

    //lezem nzidou les videos eli fel Course ama ma3raftech kifech nestockihom eli 3andou fekra iguedha

    public Course() {
    }

    public Course(@NotNull long id, @NotNull String name, @NotNull String description, @NotNull String backGroundImage,
                  @NotNull float price, Coach coach, Client client) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.backGroundImage = backGroundImage;
        this.price = price;
        this.coach = coach;
        this.client = client;
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

    public String getBackGroundImage() {
        return backGroundImage;
    }

    public void setBackGroundImage(String backGroundImage) {
        this.backGroundImage = backGroundImage;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Coach getCoach() {
		return coach;
	}

	public void setCoach(Coach coach) {
		this.coach = coach;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}
}
