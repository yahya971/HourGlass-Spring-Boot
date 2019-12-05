package com.Project.Hourglass.Controllers;

import com.Project.Hourglass.Repositories.UserRepository;
import com.Project.Hourglass.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping({"user"})
public class UserController {

    @Autowired
    public UserRepository userRepo;
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id){
        return userRepo.findById(id).get();
    }

}

