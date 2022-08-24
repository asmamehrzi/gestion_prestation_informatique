package com.example.demo.repository;

import com.example.demo.model.TypeMission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface typeMissionRepository extends JpaRepository<TypeMission,Long> {
}
