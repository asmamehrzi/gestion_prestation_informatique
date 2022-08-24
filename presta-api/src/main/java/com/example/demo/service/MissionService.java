package com.example.demo.service;

import com.example.demo.model.Mission;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MissionService {
    Mission addMission(Mission mission);
    List<Mission> listMissions();
    ResponseEntity<Mission> getMissionById(Long id) ;
    String deleteMission(Long Id);
    ResponseEntity<Mission> updateMission(long id,Mission mission);
    public Long count();
}
