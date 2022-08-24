package com.example.demo.sec.service;


import com.example.demo.sec.model.AppRole;
import com.example.demo.sec.model.AppUser;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AccountService {
    AppUser addNewUser(AppUser appUser);
    AppRole addNewRole(AppRole appRole);
    void addRoleToUser(String username,String roleName);
    AppUser loadUserByUsername(String username);
    List<AppUser> listUsers();
    ResponseEntity<AppUser> getUserById(Long id) ;
     String deleteUser(Long Id);
    }