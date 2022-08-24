package com.example.demo.controller;

import com.example.demo.model.Domaine;
import com.example.demo.service.DomaineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class DomaineController {
    @Autowired
    private DomaineService domaineService;

    @GetMapping("/domaines")
    public List<Domaine> getAlldomaine() {

        return this.domaineService.listDomaine();
    }

    @GetMapping("/domaines/{id}")
    public ResponseEntity<Domaine> getDomaineById(@PathVariable(value = "id") Long Id) {
        return domaineService.getDomaineById(Id);
    }
    @PostMapping("/domaines")
    public Domaine createDomaine(@RequestBody Domaine domaine) {

        return domaineService.addDomaine(domaine);
    }
    @DeleteMapping("/domaines/{id}")
    public String deleteDomaine(@PathVariable(value = "id") Long Id) {

        domaineService.deleteDomaine(Id);
        return "Deleted Successfully";
    }
    @PutMapping("/domaines/{id}")
    public ResponseEntity<Domaine> updateDomaine(@PathVariable(value = "id") Long Id,
                                                       @RequestBody Domaine DomaineDetails) {
        Domaine domaine = domaineService.getDomaineById(Id).getBody();
        domaine.setNom_domaine(DomaineDetails.getNom_domaine());

        final Domaine updatedDomaine = domaineService.addDomaine(domaine);
        return ResponseEntity.ok(updatedDomaine);
    }
}
