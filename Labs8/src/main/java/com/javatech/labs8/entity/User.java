package com.javatech.labs8.entity;

import com.javatech.labs8.security.UserRole;

import javax.faces.bean.SessionScoped;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@javax.persistence.Entity
@NamedQueries({
        @NamedQuery(name = "User.findAll", query = "Select e from User e"),
        @NamedQuery(name = "User.findByName", query = "Select e from User e where e.name = ?1")
})
@SessionScoped
public class User implements Entity, Serializable {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 5, max = 20)
    private String name;

    @NotNull
    private String password;

    @NotNull
    @Enumerated(EnumType.STRING)
    private UserRole role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role=" + role +
                '}';
    }
}
