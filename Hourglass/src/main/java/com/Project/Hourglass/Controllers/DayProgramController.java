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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Project.Hourglass.Repositories.DayprogramRepository;
import com.Project.Hourglass.model.Coach;
import com.Project.Hourglass.model.Dayprogram;
import com.Project.Hourglass.model.User;

@CrossOrigin
@RestController
@RequestMapping(value = "/dayProgram",
produces = "application/json",
method = {RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST})
public class DayProgramController {
	@Autowired
	DayprogramRepository dayProgramRepo;
	
	@GetMapping("/{id}")
	public Dayprogram getDayProgram(@PathVariable Long id) {
		return dayProgramRepo.findById(id).get();	
	}
	
	  @GetMapping("")
	    public List<Dayprogram> getAllDayPrograms() {
	        return dayProgramRepo.findAll();
	    }
	  
	  
	  
	  @PostMapping("/addDayProgram")
	    public Dayprogram createOrSaveCoach(@RequestBody Dayprogram newprogram) {
	        return dayProgramRepo.save(newprogram);
	    }

	    @DeleteMapping("delDayProgram/{id}")
	    void deleteDayProgram(@PathVariable Long id) {
	        dayProgramRepo.deleteById(id);
	    }

	    @PutMapping("/updateProgram/{id}")
	    Dayprogram updateprogram(@RequestBody Dayprogram newprogram, @PathVariable Long id) {
	        return dayProgramRepo.findById(id).map(program -> {
	            program.setDay(newprogram.getDay());
	            program.setDescription(newprogram.getDescription());
	            return dayProgramRepo.save(program);   
	        }).orElseGet(() -> {
	            newprogram.setId(id);
	            return dayProgramRepo.save(newprogram);
	        });
	    }
	   
}
