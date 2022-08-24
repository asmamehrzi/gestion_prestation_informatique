package com.example.demo.service;
import com.example.demo.model.TypeConsultant;
import com.example.demo.repository.TypeConsultantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TypeConsultantServiceImpl  implements TypeConsultantService {
    @Autowired
    private TypeConsultantRepository typeConsultantRepository;

    @Override
    public TypeConsultant addTypeConsultant(TypeConsultant typeConsultant) {
        return typeConsultantRepository.save(typeConsultant);
    }

    @Override
    public List<TypeConsultant> listTypeConsultants() {
        return typeConsultantRepository.findAll();
    }

    @Override
    public ResponseEntity<TypeConsultant> getTypeConsultantById(Long id) {
        TypeConsultant typeConsultant = typeConsultantRepository.findById(id).get();
        return ResponseEntity.ok(typeConsultant);
    }

    @Override
    public String deleteTypeConsultant(Long Id) {
        TypeConsultant typeConsultant = typeConsultantRepository.findById(Id).get();

        typeConsultantRepository.delete(typeConsultant);
        return "Deleted Successfully";
    }

    @Override
    public ResponseEntity<TypeConsultant> updateTypeConsultant(long id, TypeConsultant typeConsultant) {
        TypeConsultant typeConsultant1 = typeConsultantRepository.findById(id).get();
        typeConsultant1.setTypeConsultant(typeConsultant.getTypeConsultant());

        final TypeConsultant updatedtype = typeConsultantRepository.save(typeConsultant1);
        return ResponseEntity.ok(updatedtype);
    }




}
