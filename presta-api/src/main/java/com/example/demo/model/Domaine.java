package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
@Entity
@Table(name = "domaine")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Domaine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom_domaine;
    @OneToMany(mappedBy = "domaine")
    private Collection<Competance> competances =new ArrayList<>();}
