package com.jtechnologies.labs5.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="exams", schema = "public")
@NamedQueries({
        @NamedQuery(name = "Exam.findAll", query = "select e from Exam e"),
        @NamedQuery(name = "Exam.updateExam", query = "update Exam set  subject = :subject, starting = :starting, duration=:duration where id = :examId"),

})
public class Exam implements Model,Serializable {
    @Id
    @SequenceGenerator(name="exam_id_seq",
            sequenceName="exam_id_seq",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator="exam_id_seq")
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @Column(name = "subject")
    private String subject;

    @Basic(optional = false)
    @Column(name = "starting")
    private String starting;

    @Basic(optional = false)
    @Column(name = "duration")
    private int duration;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Resource> resources;

    public Exam(Integer id, String subject, String starting, int duration) {
        this.id = id;
        this.subject = subject;
        this.starting = starting;
        this.duration = duration;
    }

    public Exam(String subject, String starting, int duration) {
        this.subject = subject;
        this.starting = starting;
        this.duration = duration;
    }

    public Exam() {

    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getStarting() {
        return starting;
    }

    public void setStarting(String starting) {
        this.starting = starting;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

}
