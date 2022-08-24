package com.example.demo.service;

import com.example.demo.model.TypeConsultant;
import com.example.demo.model.TypeMission;
import com.example.demo.repository.typeMissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class TypeMissionServiceImpl implements TypeMissionService{
    @Autowired
    private typeMissionRepository typemissionRepository;

    @Override
    public TypeMission addTypeMission(TypeMission typeMission) {
        return typemissionRepository.save(typeMission);
    }

    @Override
    public List<TypeMission> listTypeMissions() {
        return typemissionRepository.findAll();
    }

    @Override
    public ResponseEntity<TypeMission> getTypeMissionById(Long id) {
        TypeMission typeMission = typemissionRepository.findById(id).get();
        return ResponseEntity.ok(typeMission);    }

    @Override
    public String deleteTypeMission(Long Id) {
        TypeMission typeMission = typemissionRepository.findById(Id).get();

        typemissionRepository.delete(typeMission);
        return "Deleted Successfully";    }

    @Override
    public ResponseEntity<TypeMission> updateTypeMission(long id, TypeMission typeMission) {
        TypeMission typeMission1 = typemissionRepository.findById(id).get();
        typeMission1.setTypeMission(typeMission.getTypeMission());

        final TypeMission updatedtype = typemissionRepository.save(typeMission1);
        return ResponseEntity.ok(updatedtype);    }
}
