package com.Project.Hourglass.Controllers;


import com.Project.Hourglass.Repositories.AdministratorRepository;
import com.Project.Hourglass.model.Administrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping({"Administrator"})
public class AdministratorController {

    @Autowired
    public AdministratorRepository administratorRepo;
    @GetMapping("/{id}")
    public Administrator getAdministrator(@PathVariable Long id){
        return administratorRepo.findById(id).get();
    }

}

