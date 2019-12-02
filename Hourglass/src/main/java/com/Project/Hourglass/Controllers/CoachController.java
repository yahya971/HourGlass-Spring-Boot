package com.Project.Hourglass.Controllers;

import com.Project.Hourglass.model.Coach;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoachController {

    @RequestMapping({"coach"})
    @GetMapping("/{id}")
    public Coach getCoach(@PathVariable int id){
        return findCoachById(id);
    }


    private Coach findCoachById(int id) {
        return null;
    }

}
