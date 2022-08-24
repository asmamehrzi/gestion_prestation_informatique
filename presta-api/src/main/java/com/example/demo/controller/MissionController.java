package com.example.demo.controller;


import com.example.demo.model.Mission;
import com.example.demo.service.MissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class MissionController {
    @Autowired
    private MissionService missionService;

    @GetMapping("/missions")
    public List<Mission> getAllMissions() {

        return this.missionService.listMissions();
    }

    @GetMapping("/missions/{id}")
    public ResponseEntity<Mission> getMissionById(@PathVariable(value = "id") Long Id) {
        return missionService.getMissionById(Id);
    }
    @PostMapping("/missions")
    public Mission createMission(@RequestBody Mission mission) {

        return missionService.addMission(mission);
    }
    @DeleteMapping("/missions/{id}")
    public String deleteMission(@PathVariable(value = "id") Long Id) {

        missionService.deleteMission(Id);
        return "Deleted Successfully";
    }
    @PutMapping("/missions/{id}")
    public ResponseEntity<Mission> updateMission(@PathVariable(value = "id") Long Id,
                                                   @RequestBody Mission missionDetails) {
        Mission mission = missionService.getMissionById(Id).getBody();
        mission.setAdresse(missionDetails.getAdresse());
        mission.setDatedebut(missionDetails.getDatedebut());
        mission.setDescription(missionDetails.getDescription());

        final Mission updatedmission = missionService.addMission(mission);
        return ResponseEntity.ok(updatedmission);
    }

    @GetMapping("/missions/count")
    public Long count() {

        return missionService.count();
    }

}
