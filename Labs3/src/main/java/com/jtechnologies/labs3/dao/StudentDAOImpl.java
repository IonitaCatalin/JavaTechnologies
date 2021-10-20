package com.jtechnologies.labs3.dao;

import com.jtechnologies.labs3.models.Student;

import java.sql.SQLException;
import java.util.List;

public class StudentDAOImpl implements StudentDAO{
    @Override
    public List<Student> getAllStudents() throws SQLException {
        return null;
    }

    @Override
    public Student getStudentById(String id) throws SQLException {
        return null;
    }

    @Override
    public void addStudent(Student student) throws SQLException {

    }

    @Override
    public void removeStudentById(String id) throws SQLException{

    }
}
