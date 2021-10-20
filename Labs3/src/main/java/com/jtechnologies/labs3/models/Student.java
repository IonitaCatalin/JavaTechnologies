package com.jtechnologies.labs3.models;

import java.util.List;

public class Student {
    private String id;
    private String fullName;
    private List<Exam> exams;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<Exam> getExams() {
        return exams;
    }

    public void setExams(List<Exam> exams) {
        this.exams = exams;
    }

    public Student(String fullName) {
        this.fullName = fullName;
    }
}
