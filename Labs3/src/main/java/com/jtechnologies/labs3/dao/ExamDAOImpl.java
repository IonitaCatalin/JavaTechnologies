package com.jtechnologies.labs3.dao;

import com.jtechnologies.labs3.models.Exam;
import com.jtechnologies.labs3.utils.ConnectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ExamDAOImpl implements ExamDAO {

    public ExamDAOImpl() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
    }

    @Override
    public List<Exam> getAllExams() throws SQLException {
        return null;
    }

    @Override
    public Exam getExamById(String id) throws SQLException {
        return null;
    }

    @Override
    public void removeExamById(String id) throws SQLException {

    }

    @Override
    public void addExam(Exam exam) throws SQLException {

        Connection dbcon = ConnectionFactory.getConnection();
        PreparedStatement stmt =  dbcon.prepareStatement("INSERT INTO exams VALUES (?,?,?,?);");
        stmt.setString(1,exam.getSubject());
        stmt.setString(2,exam.getDuration());
        stmt.setString(3,exam.getStarting());

        dbcon.commit();

    }
}
