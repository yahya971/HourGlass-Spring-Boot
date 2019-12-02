package com.Project.Hourglass.Controllers;

import com.Project.Hourglass.model.Client;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"client"})
public class ClientController {


    @GetMapping("/{id}")
    public Client getClient(@PathVariable int id){
        return findClientById(id);
    }


    private Client findClientById(int id) {
        return null;
    }
}
