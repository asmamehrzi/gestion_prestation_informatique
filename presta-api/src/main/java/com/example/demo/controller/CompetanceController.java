package com.example.demo.controller;

import com.example.demo.model.Competance;
import com.example.demo.service.CompetanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/api/v1")
public class CompetanceController {
    @Autowired
    private CompetanceService competanceService;

    @GetMapping("/competances")
    public List<Competance> getAllCompetance() {

        return this.competanceService.listCompetance();
    }

    @GetMapping("/competances/{id}")
    public ResponseEntity<Competance> getCompetanceById(@PathVariable(value = "id") Long Id) {
        return competanceService.getCompetanceById(Id);
    }
    @PostMapping("/competances")
    public Competance createCompetance(@RequestBody Competance competance) {

        return competanceService.addCompetance(competance);
    }
    @DeleteMapping("/competances/{id}")
    public String deleteCompetance(@PathVariable(value = "id") Long Id) {

        competanceService.deleteCompetance(Id);
        return "Deleted Successfully";
    }
    @PutMapping("/competances/{id}")
    public ResponseEntity<Competance> updateCompetance(@PathVariable(value = "id") Long Id,
                                               @RequestBody Competance CompetanceDetails) {
        Competance competance = competanceService.getCompetanceById(Id).getBody();
        competance.setNom_competance(CompetanceDetails.getNom_competance());
        competance.setDescription(CompetanceDetails.getDescription());

        final Competance updatedCompetance = competanceService.addCompetance(competance);
        return ResponseEntity.ok(updatedCompetance);
    }



}
