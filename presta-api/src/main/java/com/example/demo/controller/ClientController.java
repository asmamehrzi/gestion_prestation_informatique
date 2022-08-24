package com.example.demo.controller;

import com.example.demo.model.Client;
import com.example.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/clients")
    public List<Client> getAllClients() {

        return this.clientService.listClient();
    }

    @GetMapping("/clients/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable(value = "id") Long Id) {
        return clientService.getClientById(Id);
    }
    @PostMapping("/clients")
    public Client createClient(@RequestBody Client client) {

        return clientService.addClient(client);
    }
    @DeleteMapping("/clients/{id}")
    public String deleteClient(@PathVariable(value = "id") Long Id) {

        clientService.deleteClient(Id);
        return "Deleted Successfully";
    }
    @PutMapping("/clients/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable(value = "id") Long Id,
                                                       @RequestBody Client clientDetails) {
        Client client = clientService.getClientById(Id).getBody();
        client.setEmail(clientDetails.getEmail());
        client.setPassword(clientDetails.getPassword());
        client.setPays(clientDetails.getPays());
        client.setNomEntreprise(clientDetails.getNomEntreprise());
        client.setSiret(clientDetails.getSiret());
        client.setMissions(clientDetails.getMissions());
        final Client updatedClient = clientService.addClient(client);
        return ResponseEntity.ok(updatedClient);
    }
    @GetMapping("/clients/count")
    public Long count() {

        return clientService.count();
    }



}
