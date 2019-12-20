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

import com.Project.Hourglass.Repositories.SportsprogramRepository;
import com.Project.Hourglass.Repositories.WorkoutRepository;
import com.Project.Hourglass.model.Dayprogram;
import com.Project.Hourglass.model.Meal;
import com.Project.Hourglass.model.Nutritionalprogram;
import com.Project.Hourglass.model.Sportsprogram;
import com.Project.Hourglass.model.Workout;

@CrossOrigin
@RestController
@RequestMapping({"sportsProgram"})
public class  SportsProgramController{
	@Autowired
	SportsprogramRepository sportsprogramRepo;
	@Autowired
	WorkoutRepository workoutRepo;
	
	@GetMapping("/{id}")
	public Sportsprogram getProgram(@PathVariable Long id) {
		return sportsprogramRepo.findById(id).get();	
	}
	
	@GetMapping("/")
	public List<Sportsprogram> getAllSportsProgram(){
		return sportsprogramRepo.findAll();
	}


	@PostMapping("/addSportsProgram/{ids}")
	public Sportsprogram createOrSaveNutritionalProgram(@RequestBody Sportsprogram newSportsprogram,@PathVariable String ids){
		String[] idArrays=ids.split(",");
		for(String sId: idArrays) {
			Long id=Long.parseLong(sId);
			Workout workout=workoutRepo.findById(id).get();
			newSportsprogram.getWorkouts().add(workout);
			
		}
		return sportsprogramRepo.save(newSportsprogram);
	}

	@DeleteMapping("delSportsProgram/{id}")
	public void deleteSportsProgram(@PathVariable Long id){
		sportsprogramRepo.deleteById(id);
	}

	@PutMapping("updateSportsProgram/{id}")
	public Sportsprogram updateSportsProgram(@RequestBody Sportsprogram newSportsProgram, @PathVariable Long id){
		return sportsprogramRepo.findById(id).map(
				sProgram -> {
					sProgram.setDay(newSportsProgram.getDay());
					sProgram.setDescription(newSportsProgram.getDescription());
				

					return sportsprogramRepo.save(sProgram);
				}
		).orElseGet(() -> {
					newSportsProgram.setId(id);
					return sportsprogramRepo.save(newSportsProgram);
				}
		);
	}
    @GetMapping("/byWeightLossProgram/{id}")
    public List<Sportsprogram> getAllDayPrograms(@PathVariable Long id) {
        return sportsprogramRepo.findSportsprogramByWeightlossprogramId(id);
    }
}
