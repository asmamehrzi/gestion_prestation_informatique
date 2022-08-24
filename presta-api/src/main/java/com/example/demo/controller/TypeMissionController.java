package com.example.demo.controller;

import com.example.demo.model.TypeMission;
import com.example.demo.service.TypeMissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class TypeMissionController {
    @Autowired
    private TypeMissionService typeMissionService;

    @GetMapping("/typeMissions")
    public List<TypeMission> getAlltypeMission() {

        return this.typeMissionService.listTypeMissions();
    }

    @GetMapping("/typeMissions/{id}")
    public ResponseEntity<TypeMission> gettypeMissionyId(@PathVariable(value = "id") Long Id) {
        return typeMissionService.getTypeMissionById(Id);
    }
    @PostMapping("/typeMissions")
    public TypeMission createtypeMission(@RequestBody TypeMission typeMission) {

        return typeMissionService.addTypeMission(typeMission);
    }
    @DeleteMapping("/typeMissions/{id}")
    public String deletetypeMission(@PathVariable(value = "id") Long Id) {

        typeMissionService.deleteTypeMission(Id);
        return "Deleted Successfully";
    }
    @PutMapping("/typeMissions/{id}")
    public ResponseEntity<TypeMission> updatetypeMission(@PathVariable(value = "id") Long Id,
                                                               @RequestBody TypeMission TypeMissionDetail) {
        TypeMission typeMission = typeMissionService.getTypeMissionById(Id).getBody();
        typeMission.setTypeMission(TypeMissionDetail.getTypeMission());


        final TypeMission updatedTypeMission = typeMissionService.addTypeMission(typeMission);
        return ResponseEntity.ok(updatedTypeMission);
    }

}
