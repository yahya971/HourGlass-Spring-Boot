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

    @GetMapping("/byUsername/{username}")
    public Client getClientByUsername(@PathVariable String username) {
        return clientRepo.findByUsername(username).get();
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
            client.setFatDistribution(newclient.getFatDistribution());
            client.setSilhouette(newclient.getSilhouette());
            client.setFrame(client.getFrame());
            client.setPassword(client.getPassword());
            client.setDesiredWeight(client.getDesiredWeight());
            return clientRepo.save(client);
        }).orElseGet(() -> {
            newclient.setId(id);
            return clientRepo.save(newclient);
        });
    }
}
