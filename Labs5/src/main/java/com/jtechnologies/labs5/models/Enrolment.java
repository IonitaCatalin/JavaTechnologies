package com.jtechnologies.labs5.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "enrolments", schema = "public")
@NamedQueries({
        @NamedQuery(name = "Enrolments.findAll", query = "select e from Enrolment e"),
        @NamedQuery(name = "Enrolments.findByIds", query = "select e from Enrolment e where e.studentId = :studentId and e.examsId = :examsId"),
        @NamedQuery(name = "Enrolments.findEnrolmentsByStudentId", query = "select e from Enrolment e where e.studentId = :studentId"),
        @NamedQuery(name = "Enrolments.findEnrolmentsByExamId", query = "select e from Enrolment e where e.examsId = :examId"),
        @NamedQuery(name = "Enrolments.updateEnrolment", query = "update Enrolment set examsId = :examId where id = :enrolmentId")
})
public class Enrolment implements Serializable {

    @Id
    @SequenceGenerator(name="enrolment_id_seq",
            sequenceName="enrolment_id_seq",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator="enrolment_id_seq")
    @Column(name = "id")
    private Integer id;

    @Column(name = "student_id")
    @Basic(optional = false)
    private int studentId;

    @Column(name = "exam_id")
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
