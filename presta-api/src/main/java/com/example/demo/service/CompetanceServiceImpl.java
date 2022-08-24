package com.example.demo.service;

import com.example.demo.model.Competance;
import com.example.demo.repository.CompetanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class CompetanceServiceImpl implements CompetanceService{
    @Autowired
    private CompetanceRepository competanceRepository;
    @Override
    public Competance addCompetance(Competance competance) {
        return competanceRepository.save(competance);
    }

    @Override
    public List<Competance> listCompetance() {
        return competanceRepository.findAll();
    }

    @Override
    public ResponseEntity<Competance> getCompetanceById(Long id) {
        Competance competance = competanceRepository.findById(id).get();
        return ResponseEntity.ok(competance);    }

    @Override
    public String deleteCompetance(Long Id) {
        Competance competance = competanceRepository.findById(Id).get();

        competanceRepository.delete(competance);
        return "Deleted Successfully";
    }

    @Override
    public ResponseEntity<Competance> updateCompetance(long id, Competance competance) {
        Competance competance1 = competanceRepository.findById(id).get();
        competance1.setNom_competance(competance.getNom_competance());
        competance1.setDescription(competance.getDescription());

        final Competance updatedcompetance= competanceRepository.save(competance1);
        return ResponseEntity.ok(updatedcompetance);
    }
}
