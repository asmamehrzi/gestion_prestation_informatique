package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
@Table(name = "mission")
public class Mission {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    public  String adresse;
    @JsonFormat(pattern="yyyy-MM-dd")
    public Date datedebut;
    public String description;
    public String duration;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Consultant> consultants =new ArrayList<>();
    @ManyToOne
    private Client client;
    @ManyToOne
    private TypeMission typemission;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Competance> competances =new ArrayList<>();
}
