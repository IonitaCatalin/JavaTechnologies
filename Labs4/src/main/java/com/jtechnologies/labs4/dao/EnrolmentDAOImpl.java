package com.jtechnologies.labs4.dao;

import com.jtechnologies.labs4.models.Enrolment;
import com.jtechnologies.labs4.models.Exam;
import com.jtechnologies.labs4.utils.PostgresRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EnrolmentDAOImpl implements EnrolmentDAO{

    private final PostgresRepository postgresRepository;

    public EnrolmentDAOImpl() {
        postgresRepository = PostgresRepository.get();
    }

    @Override
    public List<Enrolment> getEnrolments() {

        List<Enrolment> enrolments = new ArrayList<>();
        ResultSet resultSet = postgresRepository.run("SELECT * FROM ENROLMENT");

        while(true){
            try {
                if (!resultSet.next())
                {
                    break;
                }
                enrolments.add(new Enrolment(
                        resultSet.getInt("id"),
                        resultSet.getInt("student_id"),
                        resultSet.getInt("exam_id") ));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return enrolments;
    }

    @Override
    public Exam getEnrolmentById(int id) {
        return null;
    }

    @Override
    public void removeEnrolmentById(int id) {
        String query = "DELETE FROM ENROLMENT WHERE ID = " + id;
        postgresRepository.run(query);
    }

    @Override
    public void addEnrolment(Enrolment enrolment) {
        String query = "INSERT INTO ENROLMENT(STUDENT_ID,EXAM_ID) VALUES (" +
                "'" +enrolment.getStudentId()+"',"+
                "'" + enrolment.getExamId() + "'" + ");";

        postgresRepository.run(query);

    }
}
