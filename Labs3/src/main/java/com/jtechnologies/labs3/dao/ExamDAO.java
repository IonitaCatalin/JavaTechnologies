package com.jtechnologies.labs3.dao;

import com.jtechnologies.labs3.models.Exam;

import java.sql.SQLException;
import java.util.List;

public interface ExamDAO {
    public List<Exam> getAllExams() throws SQLException;
    public Exam getExamById(String id) throws SQLException;
    public void removeExamById(String id) throws SQLException;
    public void addExam(Exam exam) throws SQLException;
}
