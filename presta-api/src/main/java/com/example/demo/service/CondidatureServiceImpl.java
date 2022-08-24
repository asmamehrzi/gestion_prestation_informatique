package com.example.demo.service;


import com.example.demo.model.Condidature;
import com.example.demo.repository.CondidatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CondidatureServiceImpl implements CondidatureService {
    @Autowired
    private CondidatureRepository condidatureRepository;
    @Override
    public Condidature addCondidature(Condidature condidature) {
        return condidatureRepository.save(condidature);
    }

    @Override
    public List<Condidature> listCondidature() {
        return condidatureRepository.findAll();
    }

    @Override
    public ResponseEntity<Condidature> getCondidatureById(Long id) {
        Condidature condidature = condidatureRepository.findById(id).get();
        return ResponseEntity.ok(condidature);
    }

    @Override
    public String deleteCondidature(Long Id) {
        Condidature condidature = condidatureRepository.findById(Id).get();

        condidatureRepository.delete(condidature);
        return "Deleted Successfully";    }

    @Override
    public ResponseEntity<Condidature> updateCondidature(long id, Condidature condidature) {
        Condidature condidature1 = condidatureRepository.findById(id).get();
        condidature1.setPrenom(condidature.getPrenom());
        condidature1.setEmail(condidature.getEmail());
        condidature1.setPays(condidature.getPays());
        condidature1.setTel(condidature.getTel());
        condidature1.setCv(condidature.getCv());
        final Condidature updatedCondidature = condidatureRepository.save(condidature1);
        return ResponseEntity.ok(updatedCondidature);    }

    @Override
    public Long count() {
        return condidatureRepository.count();
    }
}
