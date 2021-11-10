package com.jtechnologies.labs5.dao;

import com.jtechnologies.labs5.models.Exam;

import java.util.List;

public interface ExamDAO {
    List<Exam> getExams() ;
    Exam getExamById(int id) ;
    void removeExamById(int id) ;
    void addExam(Exam exam) ;
}
