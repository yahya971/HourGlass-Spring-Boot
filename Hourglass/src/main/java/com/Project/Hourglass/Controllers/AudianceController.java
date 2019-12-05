package com.Project.Hourglass.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Project.Hourglass.Repositories.AudianceRepository;
import com.Project.Hourglass.model.Audiance;

@CrossOrigin
@RestController
@RequestMapping({"Audiance"})
public class AudianceController {
	@Autowired
	public AudianceRepository audianceRepo;
	
	@GetMapping("/{id}")
	public Audiance getAudiance (@PathVariable Long id) {
		return audianceRepo.findById(id).get();
		
	}
}
