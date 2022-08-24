package com.example.demo.service;

import com.example.demo.model.Client;
import com.example.demo.model.Domaine;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DomaineService {
    Domaine addDomaine(Domaine domaine);
    List<Domaine> listDomaine();
    ResponseEntity<Domaine> getDomaineById(Long id) ;
    String deleteDomaine(Long Id);
    ResponseEntity<Domaine> updateDomaine(long id,Domaine domaine);


}

