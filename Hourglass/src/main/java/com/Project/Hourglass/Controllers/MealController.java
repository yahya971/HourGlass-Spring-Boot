package com.Project.Hourglass.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Project.Hourglass.Repositories.CoachRepository;
import com.Project.Hourglass.Repositories.MealRepository;
import com.Project.Hourglass.model.Coach;
import com.Project.Hourglass.model.Meal;


@CrossOrigin
@RestController
@RequestMapping(value = "/meal",
produces = "application/json",
method = {RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST})
public class  MealController{
	@Autowired
	public MealRepository mealRepo;
	@Autowired
	public CoachRepository coachRepo;
	
	@GetMapping("/{id}")
	public Meal getMeal(@PathVariable Long id) {
		return mealRepo.findById(id).get();	
	}
	@GetMapping("/{id}/{coachId}")
	public Meal getMealByCoachId(@PathVariable Long id,@PathVariable Long coachId) {
		return mealRepo.findByIdAndCoachId(id, coachId);
	}
	@GetMapping("")
    public List<Meal> getAllMeals() {
        return mealRepo.findAll();
    }

    @PostMapping("/addMeal/{coachId}")
    public Meal createOrSaveMeal(@RequestBody Meal newMeal,@PathVariable int coachId) {
    	System.out.println("coach id"+coachId);
    	Coach coach=coachRepo.findById((long) coachId).get();
    	newMeal.setCoach(coach);
        return mealRepo.save(newMeal);
    }

    @DeleteMapping("delMeal/{id}")
    void deleteMeal(@PathVariable Long id) {
        mealRepo.deleteById(id);
    }

    @PutMapping("/updateMeal/{id}")
    Meal updateMeal(@RequestBody Meal newmeal, @PathVariable Long id) {
        return mealRepo.findById(id).map(meal -> {
            meal.setTime(newmeal.getTime());
            meal.setCaloricValue(newmeal.getCaloricValue());
            meal.setPhoto(newmeal.getPhoto());
            meal.setTaken(newmeal.isTaken());
            meal.setRecipe(newmeal.getRecipe());
            meal.setIngredients(newmeal.getIngredients());
            meal.setDescription(newmeal.getDescription());
            meal.setType(newmeal.getType());

            return mealRepo.save(meal);   
        }).orElseGet(() -> {
            newmeal.setId(id);
            return mealRepo.save(newmeal);
        });
    }

    @GetMapping("/byCoach/{id}")
    public List<Meal> getMealsByCoachId( @PathVariable Long id) {
	    return  this.mealRepo.findAllByCoachId(id);
    }
}
