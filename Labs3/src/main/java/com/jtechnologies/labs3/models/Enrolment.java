package com.jtechnologies.labs3.models;

public class Enrolment {
    private int id;
    private int studentId;
    private int examId;


    public Enrolment(int id, int studentId, int examId) {
        this.id = id;
        this.studentId = studentId;
        this.examId = examId;
    }

    public Enrolment(int studentId, int examId) {
        this.studentId = studentId;
        this.examId = examId;
    }

    public int getId() {
        return id;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getExamId() {
        return examId;
    }
}
