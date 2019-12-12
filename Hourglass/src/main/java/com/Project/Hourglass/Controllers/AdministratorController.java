package com.Project.Hourglass.Controllers;


import com.Project.Hourglass.Repositories.AdministratorRepository;
import com.Project.Hourglass.model.Administrator;
import com.Project.Hourglass.model.Client;
import com.Project.Hourglass.model.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/administrator",
produces = "application/json",
method = {RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST})
public class AdministratorController {

    @Autowired
    public AdministratorRepository administratorRepo;
    @GetMapping("/{id}")
    public Administrator getAdministrator(@PathVariable Long id){
        return administratorRepo.findById(id).get();
    }
    @GetMapping("")
    public List<Administrator> getAllAdmins() {
        return administratorRepo.findAll();
    }
    @PostMapping("/addAdministrator")
    public User createOrSaveAdministrator(@RequestBody Administrator newAdmin) {
        return administratorRepo.save(newAdmin);
    }
    @PutMapping("/update/{id}")
    Administrator updateadmin(@RequestBody Administrator newAdmin, @PathVariable Long id) {
        return administratorRepo.findById(id).map(admin -> {
            admin.setName(newAdmin.getName());
            admin.setLastname(newAdmin.getLastname());
            admin.setUsername(newAdmin.getUsername());
            return administratorRepo.save(admin);   
        }).orElseGet(() -> {
            newAdmin.setId(id);
            return administratorRepo.save(newAdmin);
        });
    }
    @DeleteMapping("delAdministrator/{id}")
    void deleteAdmin(@PathVariable Long id) {
        administratorRepo.deleteById(id);
    }

}

