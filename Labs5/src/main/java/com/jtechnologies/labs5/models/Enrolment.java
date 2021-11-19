package com.jtechnologies.labs5.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "enrolments")
@NamedQueries({
        @NamedQuery(name = "Enrolments.findByIds", query = "select e from Enrolment e where e.studentId = :studentId and e.examsId = :examsId"),
})
public class Enrolment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Column(name = "student_id")
    @Basic(optional = false)
    private int studentId;

    @Column(name = "exams_id")
    @Basic(optional = false)
    private int examsId;

    public Enrolment(Integer id, int studentId, int examsId) {
        this.id = id;
        this.studentId = studentId;
        this.examsId = examsId;
    }

    public Enrolment(int studentId, int examsId) {
        this.studentId = studentId;
        this.examsId = examsId;
    }

    public Enrolment() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getExamsId() {
        return examsId;
    }

    public void setExamsId(int examsId) {
        this.examsId = examsId;
    }
}
