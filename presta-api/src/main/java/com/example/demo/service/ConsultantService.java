package com.example.demo.service;

import com.example.demo.model.Consultant;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ConsultantService {

    Consultant addConsultant(Consultant consultant);
    List<Consultant> listConsultants();
    ResponseEntity<Consultant> getConsultantById(Long id) ;
    String deleteConsultant(Long Id);
    ResponseEntity<Consultant> updateConsultant(long id,Consultant consultant);


}
