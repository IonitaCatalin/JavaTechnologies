package com.jtechnologies.labs3.dao;

import com.jtechnologies.labs3.models.Exam;

import java.util.List;

public interface ExamDAO {
    List<Exam> getExams() ;
    Exam getExamById(String id) ;
    void removeExamById(String id) ;
    void addExam(Exam exam) ;
}
