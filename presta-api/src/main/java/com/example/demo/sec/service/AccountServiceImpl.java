package com.example.demo.sec.service;

import com.example.demo.sec.model.AppRole;
import com.example.demo.sec.model.AppUser;
import com.example.demo.sec.repository.AppRoleRepository;
import com.example.demo.sec.repository.AppUserReository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class AccountServiceImpl implements AccountService {

   @Autowired
    private  AppUserReository appUserReository;
    @Autowired
    private  AppRoleRepository appRoleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public AppUser addNewUser(AppUser appUser) {
        String pw=appUser.getPassword();
        appUser.setPassword(passwordEncoder.encode(pw));
        return appUserReository.save(appUser);
    }

    @Override
    public AppRole addNewRole(AppRole appRole) {
        return appRoleRepository.save(appRole);
    }


    @Override
    public void addRoleToUser(String username, String roleName) {
        AppUser appUser=appUserReository.findByUsername(username);
        AppRole appRole=appRoleRepository.findByRoleName(roleName);
        appUser.getAppRoles().add(appRole);
    }

    @Override
    public AppUser loadUserByUsername(String username) throws UsernameNotFoundException  {

         AppUser user= appUserReository.findByUsername(username);
        if (user == null) {throw new UsernameNotFoundException(username);
}
        return user;
    }

    @Override
    public List<AppUser> listUsers() {

        return appUserReository.findAll();
    }

    @Override
    public ResponseEntity<AppUser> getUserById(Long id) {
        AppUser user = appUserReository.findById(id).get();
        return ResponseEntity.ok(user);    }

    @Override
    public String deleteUser(Long Id) {
        AppUser user = appUserReository.findById(Id).get();

        appUserReository.delete(user);
        return "Deleted Successfully";    }

}