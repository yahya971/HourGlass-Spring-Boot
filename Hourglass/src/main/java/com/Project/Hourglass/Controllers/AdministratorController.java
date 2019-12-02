package com.Project.Hourglass.Controllers;

import com.Project.Hourglass.model.Administrator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"Administrator"})
public class AdministratorController {


    @GetMapping("/{id}")
    public Administrator getAdministrator(@PathVariable int id){
        return findAdministratorById(id);
    }


    private Administrator findAdministratorById(int id) {
        return null;
    }
}

