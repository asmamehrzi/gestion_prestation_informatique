package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "TypeConsultant")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TypeConsultant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String typeConsultant;
    @OneToMany(mappedBy = "typeconsultant")
    private Collection<Consultant> consultants =new ArrayList<>();
}
