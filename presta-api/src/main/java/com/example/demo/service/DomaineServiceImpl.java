package com.example.demo.service;

import com.example.demo.model.Domaine;
import com.example.demo.repository.DomaineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class DomaineServiceImpl implements DomaineService{
    @Autowired
    private DomaineRepository domaineRepository;
    @Override
    public Domaine addDomaine(Domaine domaine) {
        return domaineRepository.save(domaine);
    }

    @Override
    public List<Domaine> listDomaine() {
        return domaineRepository.findAll();
    }

    @Override
    public ResponseEntity<Domaine> getDomaineById(Long id) {
        Domaine domaine = domaineRepository.findById(id).get();
        return ResponseEntity.ok(domaine);      }

    @Override
    public String deleteDomaine(Long Id) {
        Domaine domaine = domaineRepository.findById(Id).get();

        domaineRepository.delete(domaine);
        return "Deleted Successfully";      }

    @Override
    public ResponseEntity<Domaine> updateDomaine(long id, Domaine domaine) {
        Domaine domaine1 = domaineRepository.findById(id).get();
        domaine1.setNom_domaine(domaine.getNom_domaine());
        final Domaine updatedDomaine = domaineRepository.save(domaine1);
        return ResponseEntity.ok(updatedDomaine);    }
}
