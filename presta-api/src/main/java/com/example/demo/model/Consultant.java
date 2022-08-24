package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "consultant")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Consultant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String password;
    private String name;
    private  String lname;
    private String pays;
    private String tel;
    @ManyToMany(mappedBy ="consultants" ,fetch = FetchType.EAGER)
    private Collection<Mission> missions =new ArrayList<>();
    @OneToMany(mappedBy = "consultant")
    private Collection<Competance> competances =new ArrayList<>();
    @ManyToOne
    private TypeConsultant typeconsultant;
    @ManyToMany(mappedBy ="consultants" ,fetch = FetchType.EAGER)
    private Collection<Competance> competancescoll =new ArrayList<>();
    @OneToMany(mappedBy = "consultant")
    private Collection<Condidature> condidatures =new ArrayList<>();
}
