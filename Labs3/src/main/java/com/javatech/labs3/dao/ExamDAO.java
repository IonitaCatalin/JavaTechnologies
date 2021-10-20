package com.javatech.labs3.dao;

import com.javatech.labs3.models.Exam;
import java.util.List;

public interface ExamDAO {
    public List<Exam> getAllExams();
    public Exam getExamById(int id);
    public void removeExamById();
    public void addExam(Exam exam);
}
