package com.jtechnologies.labs4.dao;

import com.jtechnologies.labs4.models.Student;
import com.jtechnologies.labs4.utils.PostgresRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO{

    private final PostgresRepository postgresRepository;

    public StudentDAOImpl() {
        postgresRepository = PostgresRepository.get();
    }

    @Override
    public List<Student> getStudents() {

        List<Student> students = new ArrayList<>();
        ResultSet resultSet = postgresRepository.run("SELECT * FROM STUDENTS;");

        while(true){
            try {
                if (!resultSet.next())
                {
                    break;
                }
                students.add(new Student(
                        Integer.parseInt(resultSet.getString("id")),
                        resultSet.getString("name")));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return students;
    }

    @Override
    public Student getStudentById(int id) {
        return null;
    }

    @Override
    public void addStudent(Student student) {
        String query = "INSERT INTO STUDENTS(name) VALUES (" +
                "'"+ student.getFullName()+ "'" + ")";

        postgresRepository.run(query);
    }

    @Override
    public void removeStudentById(int id) {
        String query = "DELETE FROM STUDENTS WHERE ID = " + id;
        postgresRepository.run(query);

    }
}
