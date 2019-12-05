package com.Project.Hourglass.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Project.Hourglass.Repositories.MealRepository;
import com.Project.Hourglass.model.Meal;

@CrossOrigin
@RestController
@RequestMapping({"Meal"})
public class  MealController{
	@Autowired
	public MealRepository mealRepo;
	
	@GetMapping("/{id}")
	public Meal getMeal(@PathVariable Long id) {
		return mealRepo.findById(id).get();
		
		
	}
}
