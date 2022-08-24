package com.example.demo.service;

import com.example.demo.model.Client;
import com.example.demo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ClientServiceImpl implements ClientService{
    @Autowired
    private ClientRepository clientRepository;
    @Override
    public Client addClient(Client client) {
        return clientRepository.save(client)   ;
    }

    @Override
    public List<Client> listClient() {
        return this.clientRepository.findAll();    }

    @Override
    public ResponseEntity<Client> getClientById(Long id) {
        Client client = clientRepository.findById(id).get();
        return ResponseEntity.ok(client);    }

    @Override
    public String deleteClient(Long Id) {
        Client client = clientRepository.findById(Id).get();

        clientRepository.delete(client);
        return "Deleted Successfully";        }

    @Override
    public ResponseEntity<Client> updateClient(long id, Client client) {

        Client client1 = clientRepository.findById(id).get();
        client1.setEmail(client.getEmail());
        client1.setPassword(client.getPassword());
        client1.setPays(client.getPays());
        client1.setTel(client.getTel());
        client1.setSiret(client.getSiret());
        client1.setNomEntreprise(client.getNomEntreprise());
        final Client updatedClient = clientRepository.save(client1);
        return ResponseEntity.ok(updatedClient);
    }
    public Long count() {

        return clientRepository.count();
    }
}
