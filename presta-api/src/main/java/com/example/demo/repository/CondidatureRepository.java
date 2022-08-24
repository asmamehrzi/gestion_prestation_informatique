package com.example.demo.repository;

import com.example.demo.model.Condidature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CondidatureRepository extends JpaRepository<Condidature,Long> {
}
