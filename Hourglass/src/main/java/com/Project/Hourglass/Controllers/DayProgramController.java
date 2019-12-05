package com.Project.Hourglass.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Project.Hourglass.Repositories.DayprogramRepository;
import com.Project.Hourglass.model.Dayprogram;

@CrossOrigin
@RestController
@RequestMapping({"DayProgram"})
public class DayProgramController {
	@Autowired
	DayprogramRepository dayProgramRepo;
	
	@GetMapping("/{id}")
	public Dayprogram getDayProgram(@PathVariable Long id) {
		return dayProgramRepo.findById(id).get();
		
		
	}
}
