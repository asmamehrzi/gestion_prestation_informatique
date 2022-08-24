package com.example.demo.controller;

import com.example.demo.model.TypeConsultant;
import com.example.demo.service.TypeConsultantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class TypeConsultantController {
    @Autowired
    private TypeConsultantService typeConsultantService;

    @GetMapping("/typeConsultants")
    public List<TypeConsultant> getAlltypeConsultant() {

        return this.typeConsultantService.listTypeConsultants();
    }

    @GetMapping("/typeConsultants/{id}")
    public ResponseEntity<TypeConsultant> gettypeConsultantById(@PathVariable(value = "id") Long Id) {
        return typeConsultantService.getTypeConsultantById(Id);
    }
    @PostMapping("/typeConsultants")
    public TypeConsultant createtypeConsultant(@RequestBody TypeConsultant typeConsultant) {

        return typeConsultantService.addTypeConsultant(typeConsultant);
    }
    @DeleteMapping("/typeConsultants/{id}")
    public String deletetypeConsultant(@PathVariable(value = "id") Long Id) {

        typeConsultantService.deleteTypeConsultant(Id);
        return "Deleted Successfully";
    }
    @PutMapping("/typeConsultants/{id}")
    public ResponseEntity<TypeConsultant> updatetypeConsultant(@PathVariable(value = "id") Long Id,
                                                 @RequestBody TypeConsultant typeConsultantDetail) {
        TypeConsultant typeConsultant = typeConsultantService.getTypeConsultantById(Id).getBody();
        typeConsultant.setTypeConsultant(typeConsultantDetail.getTypeConsultant());


        final TypeConsultant updatedTypeConsultant = typeConsultantService.addTypeConsultant(typeConsultant);
        return ResponseEntity.ok(updatedTypeConsultant);
    }


}
