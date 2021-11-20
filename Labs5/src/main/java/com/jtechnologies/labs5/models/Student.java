package com.jtechnologies.labs5.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="students",schema = "public")
@NamedQueries({
        @NamedQuery(name = "Student.findAll", query = "select e from Student e"),
        @NamedQuery(name = "Student.updateStudent", query = "update Student set name = :name where id = :studentId"),
        @NamedQuery(name = "Student.findStudentByName", query = "select e from Student e where e.name = :name")
})
public class Student implements Serializable {

    @Id
    @SequenceGenerator(name="student_id_seq",
            sequenceName="student_id_seq",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator="student_id_seq")
    @Column(name = "id")
    private int id;

    @Basic(optional = false)
    @Column(name = "name" )
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student(String name) {
        this.name = name;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
