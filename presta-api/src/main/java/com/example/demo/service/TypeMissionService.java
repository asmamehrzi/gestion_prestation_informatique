package com.example.demo.service;

import com.example.demo.model.TypeConsultant;
import com.example.demo.model.TypeMission;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TypeMissionService {
    TypeMission addTypeMission(TypeMission typeMission);
    List<TypeMission> listTypeMissions();
    ResponseEntity<TypeMission> getTypeMissionById(Long id) ;
    String deleteTypeMission(Long Id);
    ResponseEntity<TypeMission> updateTypeMission(long id,TypeMission typeMission);
}
