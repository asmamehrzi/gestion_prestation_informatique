package com.example.demo.service;

import com.example.demo.model.Client;
import com.example.demo.model.Competance;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CompetanceService {
    Competance addCompetance(Competance competance);
    List<Competance> listCompetance();
    ResponseEntity<Competance> getCompetanceById(Long id) ;
    String deleteCompetance(Long Id);
    ResponseEntity<Competance> updateCompetance(long id,Competance competance);
}
