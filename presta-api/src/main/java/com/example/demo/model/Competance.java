package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "competance")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Competance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom_competance;
    private String description;
    @ManyToOne
    private Consultant consultant;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Consultant> consultants =new ArrayList<>();
    @ManyToOne
    private Domaine domaine;
    @ManyToMany(mappedBy ="competances" ,fetch = FetchType.EAGER)
    private Collection<Mission> missions =new ArrayList<>();
}
