package com.Project.Hourglass.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Project.Hourglass.Repositories.WorkoutRepository;
import com.Project.Hourglass.model.Workout;

@CrossOrigin
@RestController
@RequestMapping({"Workout"})
public class  WorkoutController{
	@Autowired
	public WorkoutRepository workoutRepo;
	
	@GetMapping("/{id}")
	public Workout getWorkout(@PathVariable Long id) {
		return workoutRepo.findById(id).get();
		
		
	}
}
