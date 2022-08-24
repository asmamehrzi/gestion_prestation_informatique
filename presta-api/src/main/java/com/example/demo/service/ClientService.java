package com.example.demo.service;

import com.example.demo.model.Client;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ClientService {
    Client addClient(Client client);
    List<Client> listClient();
    ResponseEntity<Client> getClientById(Long id) ;
    String deleteClient(Long Id);
    ResponseEntity<Client> updateClient(long id,Client client);

    public Long count();
}
