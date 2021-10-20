package com.jtechnologies.labs3.dao;

import com.jtechnologies.labs3.models.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentDAO {
    List<Student> getAllStudents() throws SQLException;
    Student getStudentById(String id) throws SQLException;
    void addStudent(Student student) throws SQLException;
    void removeStudentById(String id) throws SQLException;

}
