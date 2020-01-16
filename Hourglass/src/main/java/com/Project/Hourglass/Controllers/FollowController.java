package com.Project.Hourglass.Controllers;

import com.Project.Hourglass.Repositories.FollowRepository;
import com.Project.Hourglass.model.Follow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/follow",
        produces = "application/json",
        method = {RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST})
public class FollowController {

    @Autowired
    public FollowRepository followRepo;

    @GetMapping("/{id}")
    public Follow getFollow(@PathVariable Long id) {
        return followRepo.findById(id).get();
    }

    @GetMapping("/byProgramId/{id}")
    public List<Follow> getAllFollow(@PathVariable Long id) {
        return followRepo.findAllByWeightLossProgram(id);
    }

    @GetMapping("/byProgramIdAndDay/{id}/{day}")
    public Follow getFollowByProgramAndDay(@PathVariable Long id, @PathVariable String day) {
        return followRepo.findByWeightLossProgramAndAndDay(id, day);
    }

    @PostMapping("/addFollow")
    public Follow createOrSaveFollow(@RequestBody Follow newFollow) {
        return followRepo.save(newFollow);
    }

    @DeleteMapping("delFollow/{id}")
    void deleteFollow(@PathVariable Long id) {
        followRepo.deleteById(id);
    }

    @PutMapping("/updateFollow/{id}")
    Follow updatefollow(@RequestBody Follow newfollow, @PathVariable Long id) {
        return followRepo.findById(id).map(follow -> {
            follow.setComment(newfollow.getComment());
            follow.setDay(newfollow.getDay());
            follow.setConsulted(newfollow.isConsulted());
            return followRepo.save(follow);
        }).orElseGet(() -> {
            newfollow.setId(id);
            return followRepo.save(newfollow);
        });
    }

}

