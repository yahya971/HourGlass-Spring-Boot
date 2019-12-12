package com.Project.Hourglass.Controllers;


import com.Project.Hourglass.Repositories.ClientRepository;
import com.Project.Hourglass.model.Client;
import com.Project.Hourglass.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/client",
produces = "application/json",
method = {RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST})
public class ClientController {

    @Autowired
    public ClientRepository clientRepo;
    @GetMapping("/{id}")
    public Client getClient(@PathVariable Long id){
        return clientRepo.findById(id).get();
    }
    @GetMapping("")
    public List<Client> getAllclient() {
        return clientRepo.findAll();
    }

    @PostMapping("/addClient")
    public User createOrSaveUser(@RequestBody Client newclient) {
        return clientRepo.save(newclient);
    }

    @DeleteMapping("delClient/{id}")
    void deleteclient(@PathVariable Long id) {
        clientRepo.deleteById(id);
    }

    @PutMapping("/updateclient/{id}")
    Client updateclient(@RequestBody Client newclient, @PathVariable Long id) {
        return clientRepo.findById(id).map(client -> {
            client.setName(newclient.getName());
            client.setLastname(newclient.getLastname());
            client.setAge(newclient.getAge());
            client.setPhoto(newclient.getPhoto());
            client.setHeight(newclient.getHeight());
            client.setCurrentWeight(newclient.getCurrentWeight());
            client.setUsername(newclient.getUsername());
            return clientRepo.save(client);
        }).orElseGet(() -> {
            newclient.setId(id);
            return clientRepo.save(newclient);
        });
    }
}
