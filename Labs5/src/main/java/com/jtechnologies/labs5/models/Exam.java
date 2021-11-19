package com.jtechnologies.labs5.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="exams")
@NamedQueries({
        @NamedQuery(name = "Exam.findAll", query = "select e from Exam e"),
})
public class Exam implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Basic(optional = false)
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
