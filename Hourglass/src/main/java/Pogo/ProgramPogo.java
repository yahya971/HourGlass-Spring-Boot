package Pogo;

import java.time.LocalDate;
import java.util.Date;

public class ProgramPogo {
	public ProgramPogo(String backgroundImage, String description, int duration, String objectifs, float rating,
			LocalDate startingdate, String name, AudiancePogo audiance, NutritionalPogo[] nutritionalPrograms,
			SportsPogo[] sportsPrograms) {
		super();
		this.backgroundImage = backgroundImage;
		this.description = description;
		this.duration = duration;
		this.objectifs = objectifs;
		this.rating = rating;
		this.startingdate = startingdate;
		this.name = name;
		this.audiance = audiance;
		this.nutritionalPrograms = nutritionalPrograms;
		this.sportsPrograms = sportsPrograms;
	}
	public String  backgroundImage;
	public String description;
	public int  duration;
	public String  objectifs;
	public float  rating;
	public LocalDate  startingdate;
	public String  name;
	public AudiancePogo  audiance;
	public NutritionalPogo[]  nutritionalPrograms;
	public SportsPogo[]  sportsPrograms;

}
