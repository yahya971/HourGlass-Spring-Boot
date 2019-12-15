package com.Project.Hourglass.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Project.Hourglass.Repositories.WeightlossprogramRepository;
import com.Project.Hourglass.model.Weightlossprogram;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping({"WeightLossProgram"})
public class WeightlossprogramController {
	@Autowired
	public WeightlossprogramRepository wlpRepo;
	
	
	//lezemna f kol return n specifiw l objet li bech nraj3ouh
	@GetMapping("/{id}")
	public Weightlossprogram getProgram(@PathVariable Long id) {
		
		return wlpRepo.findById(id).get();
	}

	@GetMapping("byCoach/{id}")
	public List<Weightlossprogram> getProgramByCoachId(@PathVariable Long id){
		return wlpRepo.findProgramByCoachId(id);
	}

}
