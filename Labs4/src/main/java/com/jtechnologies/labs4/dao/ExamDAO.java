package com.jtechnologies.labs4.dao;

import com.jtechnologies.labs4.models.Exam;

import java.util.List;

public interface ExamDAO {
    List<Exam> getExams() ;
    Exam getExamById(int id) ;
    void removeExamById(int id) ;
    void addExam(Exam exam) ;
}
