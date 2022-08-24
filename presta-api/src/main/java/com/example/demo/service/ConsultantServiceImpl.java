package com.example.demo.service;

import com.example.demo.model.Consultant;
import com.example.demo.repository.ConsultantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ConsultantServiceImpl implements ConsultantService {
    @Autowired
    ConsultantRepository consultantRepository;

    @Override
    public Consultant addConsultant(Consultant consultant) {
        return consultantRepository.save(consultant);
    }

    @Override
    public List<Consultant> listConsultants() {
        return consultantRepository.findAll();
    }

    @Override
    public ResponseEntity<Consultant> getConsultantById(Long id) {
        Consultant cons = consultantRepository.findById(id).get();
        return ResponseEntity.ok(cons);
    }

    @Override
    public String deleteConsultant(Long Id) {
        Consultant consultant = consultantRepository.findById(Id).get();

        consultantRepository.delete(consultant);
        return "Deleted Successfully";
    }

    @Override
    public ResponseEntity<Consultant> updateConsultant(long Id, Consultant consultant) {
        Consultant consultant1 = consultantRepository.findById(Id).get();
        consultant1.setEmail(consultant.getEmail());
        consultant1.setPassword(consultant.getPassword());
        consultant1.setName(consultant.getName());
        consultant1.setLname(consultant.getLname());
        consultant1.setPays(consultant.getPays());
        consultant1.setTel(consultant.getTel());
        final Consultant updatecons = consultantRepository.save(consultant1);
        return ResponseEntity.ok(updatecons);
    }


}