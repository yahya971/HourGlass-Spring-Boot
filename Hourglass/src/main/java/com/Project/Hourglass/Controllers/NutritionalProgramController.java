package com.Project.Hourglass.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Project.Hourglass.Repositories.NutritionalprogramRepository;
import com.Project.Hourglass.model.Nutritionalprogram;

@CrossOrigin
@RestController
@RequestMapping({"NutritionalProgram"})
public class  NutritionalProgramController{
	@Autowired
	public NutritionalprogramRepository nutProgramRepo;
	
	@GetMapping("/{id}")
	public Nutritionalprogram getProgram(@PathVariable Long id) {
		
		return nutProgramRepo.findById(id).get();
	}
}
