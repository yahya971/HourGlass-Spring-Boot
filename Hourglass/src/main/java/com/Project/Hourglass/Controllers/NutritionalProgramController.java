package com.Project.Hourglass.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.Project.Hourglass.Repositories.NutritionalprogramRepository;
import com.Project.Hourglass.model.Nutritionalprogram;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(
		value = "/nutritionalProgram",
		produces = "application/json",
		method = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE}
)
public class  NutritionalProgramController{


	@Autowired
	public NutritionalprogramRepository nutProgramRepo;
	

	@GetMapping("/{id}")
	public Nutritionalprogram getNutritionalProgram(@PathVariable Long id) {
		
		return nutProgramRepo.findById(id).get();
	}

	@GetMapping("/")
	public List<Nutritionalprogram> getAllNutritionalProgram(){
		return nutProgramRepo.findAll();
	}

	@PostMapping("/addNutritionalProgram")
	public Nutritionalprogram createOrSaveNutritionalProgram(@RequestBody Nutritionalprogram newNutritionalprogram){
		return nutProgramRepo.save(newNutritionalprogram);
	}

	@DeleteMapping("delNutritionalProgram/{id}")
	public void deleteNutritionalProgram(@PathVariable Long id){
		nutProgramRepo.deleteById(id);
	}

	@PutMapping("updateNutritionalProgram/{id}")
	public Nutritionalprogram updateNutritionalProgram(@RequestBody Nutritionalprogram newNutritionalProgram, @PathVariable Long id){
		return nutProgramRepo.findById(id).map(
				nutProgram -> {
					nutProgram.setDay(newNutritionalProgram.getDay());
					nutProgram.setDescription(newNutritionalProgram.getDescription());
					nutProgram.setMealsNumber(newNutritionalProgram.getMealsNumber());

					return nutProgramRepo.save(nutProgram);
				}
		).orElseGet(() -> {
					newNutritionalProgram.setId(id);
					return nutProgramRepo.save(newNutritionalProgram);
				}
		);
	}
}
