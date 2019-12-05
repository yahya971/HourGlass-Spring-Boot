package com.Project.Hourglass.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Project.Hourglass.Repositories.SportsprogramRepository;
import com.Project.Hourglass.model.Sportsprogram;

@CrossOrigin
@RestController
@RequestMapping({"SportsProgram"})
public class  SportsProgramController{
	@Autowired
	SportsprogramRepository sportsprogramRepo;
	
	@GetMapping("/{id}")
	public Sportsprogram getProgram(@PathVariable Long id) {
		return sportsprogramRepo.findById(id).get();
				
		
		
	}
}
