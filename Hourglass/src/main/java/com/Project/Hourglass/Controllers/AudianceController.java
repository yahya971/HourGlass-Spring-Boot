package com.Project.Hourglass.Controllers;

import com.Project.Hourglass.model.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.Project.Hourglass.Repositories.AudianceRepository;
import com.Project.Hourglass.model.Audiance;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(
		value = "/audiance",
		produces = "application/json",
		method = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE}
)
public class AudianceController {
	@Autowired
	public AudianceRepository audianceRepo;
	
	@GetMapping("/{id}")
	public Audiance getAudiance (@PathVariable Long id) {
		return audianceRepo.findById(id).get();
	}

	@GetMapping("/")
	public List<Audiance> getAllAudiance(){
		return audianceRepo.findAll();
	}

	@PostMapping("/addAudiance")
	public Audiance createOrSaveAudiance(@RequestBody Audiance newAudiance){
		return audianceRepo.save(newAudiance);
	}

	@DeleteMapping("delAudiance/{id}")
	public void deleteAudiance(@PathVariable Long id){
		audianceRepo.deleteById(id);
	}

	@PutMapping("updateAudiance/{id}")
	public Audiance updatecoach(@RequestBody Audiance newAudiance, @PathVariable Long id){
		return audianceRepo.findById(id).map(
				audiance -> {
					audiance.setSex(newAudiance.getSex());
					audiance.setHeight(newAudiance.getHeight());
					audiance.setObjectiveWeight(newAudiance.getObjectiveWeight());
					audiance.setFrame(newAudiance.getFrame());
					audiance.setFatStorage(newAudiance.getFatStorage());
					audiance.setSilhouette(newAudiance.getSilhouette());
					audiance.setObjectiveWeight(newAudiance.getObjectiveWeight());
					audiance.setWeightLossProgram(newAudiance.getWeightLossProgram());
					return audianceRepo.save(audiance);
				}
		).orElseGet(() -> {
			newAudiance.setId(id);
			return audianceRepo.save(newAudiance);
		}
		);
	}
}
