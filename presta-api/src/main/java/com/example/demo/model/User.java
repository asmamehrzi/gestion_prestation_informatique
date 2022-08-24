package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String password;
    private String name;
    private  String lname;
    private String login;
    private Integer siret;
    private String function;
    private String status;




    public User() {
    }


    public User(String email, String password, String name, String lname, String login) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.lname = lname;
        this.login = login;
    }

    public Long getId() {
        return id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSiret(Integer siret) {
        this.siret = siret;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }

    public Integer getSiret() {
        return siret;
    }

    public String getFunction() {
        return function;
    }

    public String getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public String getLname() {
        return lname;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

}
