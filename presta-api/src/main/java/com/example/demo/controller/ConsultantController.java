package com.example.demo.controller;

import com.example.demo.model.Consultant;
import com.example.demo.service.ConsultantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class ConsultantController {
    @Autowired
    private ConsultantService consultantService;


    @GetMapping("/consultants")
    public List<Consultant> getAllConsultants() {

        return this.consultantService.listConsultants();
    }
    @GetMapping("/consultants/{id}")
    public ResponseEntity<Consultant> getConsultantById(@PathVariable(value = "id") Long Id) {
        return consultantService.getConsultantById(Id);
    }
    @PostMapping("/consultants")
    public Consultant createConsultant(@RequestBody Consultant consultant) {

        return consultantService.addConsultant(consultant);
    }
    @DeleteMapping("/consultants/{id}")
    public String deleteConsultant(@PathVariable(value = "id") Long Id) {

        consultantService.deleteConsultant(Id);
        return "Deleted Successfully";
    }
    @PutMapping("/consultants/{id}")
    public ResponseEntity<Consultant> updateConsultant(@PathVariable(value = "id") Long Id,
                                           @RequestBody Consultant consultantDetails) {
       Consultant consultant = consultantService.getConsultantById(Id).getBody();
        consultant.setEmail(consultantDetails.getEmail());
        consultant.setPassword(consultantDetails.getPassword());
        consultant.setName(consultantDetails.getName());
        consultant.setLname(consultantDetails.getLname());
        consultant.setPays(consultantDetails.getPays());
        consultant.setTel(consultantDetails.getTel());
        final Consultant updatedConsultant = consultantService.addConsultant(consultant);
        return ResponseEntity.ok(updatedConsultant);
    }



}
