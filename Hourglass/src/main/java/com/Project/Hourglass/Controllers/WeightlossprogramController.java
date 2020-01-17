package com.Project.Hourglass.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.Project.Hourglass.Repositories.ClientRepository;
import com.Project.Hourglass.Repositories.CoachRepository;
import com.Project.Hourglass.Repositories.MealRepository;
import com.Project.Hourglass.Repositories.NutritionalprogramRepository;
import com.Project.Hourglass.Repositories.SportsprogramRepository;
import com.Project.Hourglass.Repositories.WeightlossprogramRepository;
import com.Project.Hourglass.Repositories.WorkoutRepository;
import com.Project.Hourglass.model.Audiance;
import com.Project.Hourglass.model.Client;
import com.Project.Hourglass.model.Coach;
import com.Project.Hourglass.model.Meal;
import com.Project.Hourglass.model.Nutritionalprogram;
import com.Project.Hourglass.model.Sportsprogram;
import com.Project.Hourglass.model.User;
import com.Project.Hourglass.model.Weightlossprogram;
import com.Project.Hourglass.model.Workout;

import Pogo.NutritionalPogo;
import Pogo.ProgramPogo;
import Pogo.SportsPogo;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@CrossOrigin
@RestController
@RequestMapping({"WeightLossProgram"})
public class WeightlossprogramController {
	@Autowired
	public WeightlossprogramRepository wlpRepo;
	@Autowired
	public ClientRepository clientRepo;
	@Autowired 
	public CoachRepository coachRepo;
	@Autowired
	public MealRepository mealRepo;
	@Autowired
	public WorkoutRepository workoutRepo;
	@Autowired
	public NutritionalprogramRepository npRepo;
	@Autowired
	public SportsprogramRepository spRepo;
	
	
	//lezemna f kol return n specifiw l objet li bech nraj3ouh
	@GetMapping("")
	public List<Weightlossprogram> getAllprogram(){
		return wlpRepo.findAll();
	}
	@GetMapping("/{id}")
	public Weightlossprogram getProgram(@PathVariable Long id) {
		
		return wlpRepo.findById(id).get();
	}

	@GetMapping("byCoach/{id}")
	public List<Weightlossprogram> getProgramByCoachId(@PathVariable Long id){
		return wlpRepo.findProgramByCoachId(id);
	}
	@GetMapping("byClient/{id}")
	public Weightlossprogram getProgramByClientId(@PathVariable Long id){
		return wlpRepo.findProgramByClientId(id);
	}

	@GetMapping("old/byClient/{id}")
	public List<Weightlossprogram> getProgramsByClientId(@PathVariable Long id) {
		return wlpRepo.findOldProgramsByClientId(id);
	}

	@PutMapping("/rateProgram/{id}")
	public Weightlossprogram rateProgram(@RequestBody Weightlossprogram newwlp, @PathVariable long id)
	{
		return wlpRepo.findById(id).map(program ->{
				program.setRating(newwlp.getRating());
				return wlpRepo.save(program);
		}).orElseGet(() -> {
			newwlp.setId(id);
			return wlpRepo.save(newwlp);
		});
	}
	@PostMapping("/{coachId}")
	public String SaveProgram(@PathVariable Long coachId,@RequestBody ProgramPogo p) {
		Client client=clientRepo.findById(Long.valueOf(999)).get();
		Coach coach=coachRepo.findById(coachId).get();
		Audiance audiance=new Audiance(p.audiance.sex,p.audiance.height,p.audiance.objectiveWeight,p.audiance.frame,p.audiance.fatStorage,p.audiance.silhouette,p.audiance.overWeightCause);
		Weightlossprogram programToSave=new Weightlossprogram(p.description,LocalDate.now(),p.duration,p.rating,p.backgroundImage,p.objectifs,client,coach,audiance,p.name, p.price);
		wlpRepo.save(programToSave);
		Weightlossprogram wlp=wlpRepo.findByName(p.name).get();
		for(NutritionalPogo np:p.nutritionalPrograms) {
			Set<Meal> meals=new HashSet<Meal>();
			for(String m:np.meals) {
				Meal meal=mealRepo.findByName(m).get();
				meals.add(meal);
			}
			Nutritionalprogram npToSave=new Nutritionalprogram(np.mealsNumber,meals,np.day,np.description,wlp, np.name);
			npRepo.save(npToSave);
			
		}
		
		for(SportsPogo wp:p.sportsPrograms) {
			Set<Workout> workouts=new HashSet<Workout>();
			for(String m:wp.workouts) {
				Workout workout=workoutRepo.findByName(m).get();
				workouts.add(workout);
			}
			Sportsprogram spToSave=new Sportsprogram(workouts,wp.day,wp.description,wlp,wp.name);
			spRepo.save(spToSave);
		}
		return "OK: "+coachId;
	}
}
