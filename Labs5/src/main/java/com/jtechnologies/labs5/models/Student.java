package com.jtechnologies.labs5.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="students")
@NamedQueries({
        @NamedQuery(name = "Student.findAll", query = "select e from Student e"),
        @NamedQuery(name = "Student.updateStudent", query = "update Student set fullName = :fullName where id = :studentId"),
})
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Basic(optional = false)
    @Column(name = "id")
    private int id;

    @Basic(optional = false)
    @Column(name = "fullName")
    private String fullName;

    public Student(int id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    public Student(String fullName) {
        this.fullName = fullName;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
