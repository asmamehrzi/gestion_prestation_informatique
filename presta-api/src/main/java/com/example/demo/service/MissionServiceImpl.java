package com.example.demo.service;

import com.example.demo.model.Mission;
import com.example.demo.repository.MissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class MissionServiceImpl implements MissionService{
    @Autowired
    private MissionRepository missionRepository;
    @Override
    public Mission addMission(Mission mission) {
        return missionRepository.save(mission);
    }

    @Override
    public List<Mission> listMissions() {
        return missionRepository.findAll();
    }

    @Override
    public ResponseEntity<Mission> getMissionById(Long id) {
        Mission mission=missionRepository.findById(id).get();

        return ResponseEntity.ok(mission);
    }

    @Override
    public String deleteMission(Long Id) {
        Mission mission = missionRepository.findById(Id).get();

        missionRepository.delete(mission);
        return "Deleted Successfully";
    }
    public ResponseEntity<Mission> updateMission(long Id, Mission mission) {
        Mission mission1 = missionRepository.findById(Id).get();
        mission1.setAdresse(mission.getAdresse());
        mission1.setDatedebut(mission.getDatedebut());
        mission1.setDescription(mission.getDescription());
        mission1.setClient(mission.getClient());

        final Mission missionupdate = missionRepository.save(mission1);
        return ResponseEntity.ok(missionupdate);
    }
    @Override
    public Long count() {
        return missionRepository.count();
    }
}
