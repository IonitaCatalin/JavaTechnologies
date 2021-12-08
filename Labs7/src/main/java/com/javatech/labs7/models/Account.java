package com.javatech.labs7.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "accounts")
@NamedQueries({
        @NamedQuery(name = "Account.findOne", query = "select e from Account e where e.name = :name and e.pw = :pw"),
})
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Basic(optional = false)
    @Column(name = "id")
    private int id;

    @Basic(optional = false)
    private String uuid;

    @Basic(optional = false)
    private String name;

    @Basic(optional = false)
    private String pw;

    @Basic(optional = true)
    private String role;


    public Account(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Account(String name, String pw) {
        this.name = name;
        this.pw = pw;
    }

    public Account() {

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
