package com.Project.Hourglass.Controllers;

import com.Project.Hourglass.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"person"})
public class PersonController {

    @GetMapping("/{id}")
    public User getPerson(@PathVariable int id){
        return findPersonById(id);
    }


    private User findPersonById(int id) {
        return null;
    }
}

