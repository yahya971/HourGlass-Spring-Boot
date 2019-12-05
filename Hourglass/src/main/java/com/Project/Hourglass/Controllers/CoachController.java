package com.Project.Hourglass.Controllers;


import com.Project.Hourglass.Repositories.CoachRepository;
import com.Project.Hourglass.model.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping({"coach"})
public class CoachController {

    @Autowired
    public CoachRepository coachRepo;
    @GetMapping("/{id}")
    public Coach getCoach(@PathVariable Long id){
        return coachRepo.findById(id).get();
    }



}
