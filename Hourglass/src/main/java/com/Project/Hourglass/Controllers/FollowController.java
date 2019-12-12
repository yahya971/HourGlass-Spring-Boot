package com.Project.Hourglass.Controllers;

import com.Project.Hourglass.Repositories.FollowRepository;
import com.Project.Hourglass.model.Follow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping({"follow"})
public class FollowController {

    @Autowired
    public FollowRepository followRepo;
    @GetMapping("/{id}")
    public Follow getFollow(@PathVariable Long id){
            return followRepo.findById(id).get();
        }

    }

