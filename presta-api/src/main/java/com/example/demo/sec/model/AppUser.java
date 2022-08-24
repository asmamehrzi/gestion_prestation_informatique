package com.example.demo.sec.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private  String username;
    private String email;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<AppRole> appRoles =new ArrayList<>();

    public AppUser(Long id, String username, String password, Collection<AppRole> appRoles) {
        Id = id;
        this.username = username;
        this.password = password;
        this.appRoles = appRoles;
    }
}

