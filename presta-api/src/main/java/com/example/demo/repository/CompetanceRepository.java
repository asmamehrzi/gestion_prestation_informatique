package com.example.demo.repository;

import com.example.demo.model.Client;
import com.example.demo.model.Competance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetanceRepository extends JpaRepository<Competance,Long> {
}
