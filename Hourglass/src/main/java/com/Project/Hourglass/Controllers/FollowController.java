package com.Project.Hourglass.Controllers;

import com.Project.Hourglass.model.Follow;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"follow"})
public class FollowController {

    @GetMapping("/{id}")
    public Follow getFollow(@PathVariable int id){
            return findFollowById(id);
        }


        private Follow findFollowById(int id) {
            return null;
        }
    }

