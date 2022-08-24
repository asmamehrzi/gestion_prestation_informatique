package com.example.demo.service;

import com.example.demo.model.Competance;
import com.example.demo.model.Condidature;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CondidatureService {
    Condidature addCondidature(Condidature condidature);
    List<Condidature> listCondidature();
    ResponseEntity<Condidature> getCondidatureById(Long id) ;
    String deleteCondidature(Long Id);
    ResponseEntity<Condidature> updateCondidature(long id, Condidature condidature);
    public Long count();
}
