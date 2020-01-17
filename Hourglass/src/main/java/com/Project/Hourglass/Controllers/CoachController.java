package com.Project.Hourglass.Controllers;


import com.Project.Hourglass.Repositories.CoachRepository;
import com.Project.Hourglass.Repositories.WeightlossprogramRepository;
import com.Project.Hourglass.model.Client;
import com.Project.Hourglass.model.Coach;
import com.Project.Hourglass.model.User;
import com.Project.Hourglass.model.Weightlossprogram;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/coach",
        produces = "application/json",
        method = {RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST})
public class CoachController {

    @Autowired
    public CoachRepository coachRepo;
    @Autowired
    public WeightlossprogramRepository wlpRepo;

    @GetMapping("/{id}")
    public Coach getCoach(@PathVariable Long id) {
    	Coach coach=coachRepo.findById(id).get();
        return coach;
    }

    @GetMapping("/byUsername/{username}")
    public Coach getCoachByUsername(@PathVariable String username) {
        return coachRepo.findByUsername(username).get();
    }

    @GetMapping("")
    public List<Coach> getAllCoach() {
        return coachRepo.findAll();
    }

    @PostMapping("/addCoach")
    public User createOrSaveCoach(@RequestBody Coach newCoach) {
        return coachRepo.save(newCoach);
    }

    @DeleteMapping("delCoach/{id}")
    void deleteCoach(@PathVariable Long id) {
        coachRepo.deleteById(id);
    }

    @PutMapping("/updateCoach/{id}")
    Coach updatecoach(@RequestBody Coach newCoach, @PathVariable Long id) {
        return coachRepo.findById(id).map(coach -> {
            coach.setName(newCoach.getName());
            coach.setLastname(newCoach.getLastname());
            coach.setAge(newCoach.getAge());
            coach.setPhoto(newCoach.getPhoto());
            coach.setResume(newCoach.getResume());
            coach.setUsername(newCoach.getUsername());
            coach.setExperience(newCoach.getExperience());
            coach.setScore1(newCoach.getScore1());
            coach.setScore2(newCoach.getScore2());
            coach.setScore3(newCoach.getScore3());
            coach.setScore4(newCoach.getScore4());
            coach.setSpeciality(newCoach.getSpeciality());
            return coachRepo.save(coach);   
        }).orElseGet(() -> {
            newCoach.setId(id);
            return coachRepo.save(newCoach);
        });
    }
    @GetMapping("{id}/clients")
    public List<Client>getClients(@PathVariable Long id)
    {   List<Client> clients=new ArrayList<Client>();
        List<Weightlossprogram> p=wlpRepo.findProgramByCoachId(id);
        for(Weightlossprogram w:p){
            clients.add(w.getClient());
        }
        return clients;
    }

    /*@GetMapping("programs/{id}")
    public List<Weightlossprogram>getProgrames(@PathVariable Long id)
    {
        return wlpRepo.findProgramByCoachId(id);
    }*/
}
