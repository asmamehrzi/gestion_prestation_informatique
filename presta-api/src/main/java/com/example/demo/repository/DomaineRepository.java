package com.example.demo.repository;

import com.example.demo.model.Domaine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DomaineRepository extends JpaRepository<Domaine,Long> {
}
