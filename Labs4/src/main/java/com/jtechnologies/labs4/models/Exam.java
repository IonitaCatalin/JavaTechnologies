package com.jtechnologies.labs4.models;

public class Exam {
    private int id;
    private String subject;
    private String starting;
    private int duration;


    public Exam(int id, String subject, String starting, int duration) {
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
    public String getSubject() {
        return subject;
    }
    public String getStarting() {
        return starting;
    }
    public int getDuration() {
        return duration;
    }
    public int getId() {return id;}
}
