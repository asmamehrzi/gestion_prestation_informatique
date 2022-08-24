package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "condidature")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Condidature {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String prenom;
    private String email;
    private String pays;
    private String tel;
    private String cv;
    @ManyToOne
    private Consultant consultant;



}
