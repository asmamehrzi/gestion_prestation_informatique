package com.example.demo.controller;

import com.example.demo.model.Condidature;
import com.example.demo.service.CondidatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/api/v1")
public class CondidatureController {
    @Autowired
    private CondidatureService condidatureService;


    @GetMapping("/condidatures")
    public List<Condidature> getAllCondidature() {

        return this.condidatureService.listCondidature();
    }
    @GetMapping("/condidatures/{id}")
    public ResponseEntity<Condidature> getCondidatureById(@PathVariable(value = "id") Long Id) {
        return condidatureService.getCondidatureById(Id);
    }
    @PostMapping("/condidatures")
    public Condidature createCondidature(@RequestBody Condidature condidature) {

        return condidatureService.addCondidature(condidature);
    }
    @DeleteMapping("/condidatures/{id}")
    public String deleteCondidature(@PathVariable(value = "id") Long Id) {

        condidatureService.deleteCondidature(Id);
        return "Deleted Successfully";
    }
    @PutMapping("/condidatures/{id}")
    public ResponseEntity<Condidature> updateCondidature(@PathVariable(value = "id") Long Id,
                                                       @RequestBody Condidature condidatureDetails) {
        Condidature condidature = condidatureService.getCondidatureById(Id).getBody();
        condidature.setPrenom(condidatureDetails.getPrenom());
        condidature.setEmail(condidatureDetails.getEmail());
        condidature.setPays(condidatureDetails.getPays());
        condidature.setTel(condidatureDetails.getTel());
        condidature.setCv(condidatureDetails.getCv());
        final Condidature updatedCondidature = condidatureService.addCondidature(condidature);
        return ResponseEntity.ok(updatedCondidature);
    }
    @GetMapping("/condidatures/count")
    public Long count() {

        return condidatureService.count();
    }

}
