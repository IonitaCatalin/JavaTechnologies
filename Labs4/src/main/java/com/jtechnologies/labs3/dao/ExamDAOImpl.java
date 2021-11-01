package com.jtechnologies.labs3.dao;

import com.jtechnologies.labs3.models.Exam;
import com.jtechnologies.labs3.utils.PostgresRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExamDAOImpl implements ExamDAO {

    private final PostgresRepository postgresRepository;

    public ExamDAOImpl() {
        postgresRepository = PostgresRepository.get();
    }

    @Override
    public List<Exam> getExams() {

        List<Exam> exams = new ArrayList<>();
        ResultSet resultSet = postgresRepository.run("SELECT * FROM EXAMS;");

        while(true){
            try {
                if (!resultSet.next())
                {
                    break;
                }
                exams.add(new Exam(
                        resultSet.getInt("id"),
                        resultSet.getString("subject"),
                        resultSet.getString("starting"),
                        Integer.parseInt(resultSet.getString("duration"))));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return exams;
    }

    @Override
    public Exam getExamById(int id) {

        Exam exam = null;
        ResultSet resultSet = postgresRepository.run("SELECT * FROM EXAM WHERE EXAM.ID=" + id +";");

        try {
            if(!resultSet.next()) {
                return null;
            } else {
                exam = new Exam(
                        resultSet.getInt("id"),
                        resultSet.getString("subject"),
                        resultSet.getString("starting"),
                        resultSet.getInt("duration"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exam;
    }

    @Override
    public void removeExamById(int id) {
        String query = "DELETE FROM EXAMS WHERE ID = " + id;
        postgresRepository.run(query);
    }

    @Override
    public void addExam(Exam exam) {

        String query = "INSERT INTO exams(subject,starting,duration) VALUES (" +
                "'"+ exam.getSubject() +"',"+
                "'"+ exam.getStarting() +"'," +
                "'" + exam.getDuration() +"'" + "); ";

        postgresRepository.run(query);
    }
}
