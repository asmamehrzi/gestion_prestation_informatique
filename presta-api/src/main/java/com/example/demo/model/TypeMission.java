package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "TypeMission")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TypeMission {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String typeMission;
    @OneToMany(mappedBy = "typemission")
    private Collection<Mission> missions =new ArrayList<>();
}
