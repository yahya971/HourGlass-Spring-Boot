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
import org.springframework.web.bind.annotation.RestController;

import com.Project.Hourglass.Repositories.CoachRepository;
import com.Project.Hourglass.Repositories.WorkoutRepository;
import com.Project.Hourglass.model.Coach;
import com.Project.Hourglass.model.Meal;
import com.Project.Hourglass.model.Workout;

@CrossOrigin
@RestController
@RequestMapping({"workout"})
public class  WorkoutController{
	@Autowired
	public WorkoutRepository workoutRepo;
	@Autowired
	public CoachRepository coachRepo;
	
	@GetMapping("/{id}")
	public Workout getWorkout(@PathVariable Long id) {
		return workoutRepo.findById(id).get();
		}
	@GetMapping("")
    public List<Workout> getAllMeals() {
        return workoutRepo.findAll();
    }

    @PostMapping("/addWorkout/{coachId}")
    public Workout createOrSaveMeal(@RequestBody Workout newWorkout,@PathVariable long coachId) {
    	Coach coach=coachRepo.findById(coachId).get();
    	newWorkout.setCoach(coach);
        return workoutRepo.save(newWorkout);
    }

    @DeleteMapping("delWorkout/{id}")
    void deleteWorkout(@PathVariable Long id) {
        workoutRepo.deleteById(id);
    }

    @PutMapping("/updateWorkout/{id}")
    Workout updateWorkout(@RequestBody Workout newWorkout, @PathVariable Long id) {
        return workoutRepo.findById(id).map(workout -> {
            workout.setBurnedCalories(newWorkout.getBurnedCalories());
            workout.setDescription(newWorkout.getDescription());
            workout.setPhoto(newWorkout.getPhoto());
            workout.setDuration(newWorkout.getDuration());
            workout.setStartingHour(newWorkout.getStartingHour());
            workout.setEquipment(newWorkout.getEquipment());
            
            return workoutRepo.save(workout);   
        }).orElseGet(() -> {
            newWorkout.setId(id);
            return workoutRepo.save(newWorkout);
        });
    }
    @GetMapping("/byCoach/{id}")
    public List<Workout> getMealsByCoachId( @PathVariable Long id) {
        return  this.workoutRepo.findAllByCoachId(id);
    }
}
