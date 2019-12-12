package com.Project.Hourglass.Controllers;
import com.Project.Hourglass.Repositories.UserRepository;
import com.Project.Hourglass.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/user",
        produces = "application/json",
        method = {RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST})
public class UserController {

    @Autowired
    public UserRepository userRepo;

    @GetMapping("/{id}")
    public User getUser (@PathVariable Long id){
        return userRepo.findById(id).get();
    }

    @GetMapping("")
    public List<User> getAllUser (){
        return userRepo.findAll();
    }

    @PostMapping("/addUser")
    public User createOrSaveUser(@RequestBody User newUser) {
        return userRepo.save(newUser);
    }

    @DeleteMapping("/delUser/{id}")
    void deleteUser(@PathVariable Long id) {
        userRepo.deleteById(id);
    }
}

