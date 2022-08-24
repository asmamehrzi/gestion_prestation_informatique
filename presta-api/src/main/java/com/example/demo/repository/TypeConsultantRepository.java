package com.example.demo.repository;

import com.example.demo.model.TypeConsultant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TypeConsultantRepository  extends JpaRepository<TypeConsultant,Long> {
}
