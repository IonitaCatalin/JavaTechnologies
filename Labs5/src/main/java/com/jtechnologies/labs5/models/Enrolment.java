package com.jtechnologies.labs5.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "students_exams", schema = "public")
@NamedQueries({
        @NamedQuery(name = "Enrolments.findAll", query = "select e from Enrolment e"),
        @NamedQuery(name = "Enrolments.findByIds", query = "select e from Enrolment e where e.studentId = :studentId and e.examId = :examId"),
        @NamedQuery(name = "Enrolments.findEnrolmentsByStudentId", query = "select e from Enrolment e where e.studentId = :studentId"),
        @NamedQuery(name = "Enrolments.findEnrolmentsByExamId", query = "select e from Enrolment e where e.examId = :examId"),
        @NamedQuery(name = "Enrolments.updateEnrolment", query = "update Enrolment set examId = :examId where id = :enrolmentId")
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

    @Column(name = "exams_id")
    @Basic(optional = false)
    private int examId;

    public Enrolment(Integer id, int studentId, int examId) {
        this.id = id;
        this.studentId = studentId;
        this.examId = examId;
    }

    public Enrolment(int studentId, int examId) {
        this.studentId = studentId;
        this.examId = examId;
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

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }


}
