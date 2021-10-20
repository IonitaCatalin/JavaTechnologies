package com.jtechnologies.labs3.models;

public class Exam {
    public String subject;
    public String starting;
    public String duration;

    public Exam(String subject, String date,String duration) {
        this.subject = subject;
        this.starting = date;
        this.duration = duration;
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

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
