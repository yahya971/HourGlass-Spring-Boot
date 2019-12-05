package com.Project.Hourglass.Controllers;


import com.Project.Hourglass.Repositories.ClientRepository;
import com.Project.Hourglass.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping({"client"})
public class ClientController {

    @Autowired
    public ClientRepository clientRepo;
    @GetMapping("/{id}")
    public Client getClient(@PathVariable Long id){
        return clientRepo.findById(id).get();
    }

}
