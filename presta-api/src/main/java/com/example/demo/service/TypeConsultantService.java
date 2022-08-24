package com.example.demo.service;

import com.example.demo.model.TypeConsultant;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TypeConsultantService {
    TypeConsultant addTypeConsultant(TypeConsultant typeConsultant);
    List<TypeConsultant> listTypeConsultants();
    ResponseEntity<TypeConsultant> getTypeConsultantById(Long id) ;
    String deleteTypeConsultant(Long Id);
    ResponseEntity<TypeConsultant> updateTypeConsultant(long id,TypeConsultant typeConsultant);
}
