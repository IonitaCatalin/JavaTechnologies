package com.javatech.labs3.dao;

import com.javatech.labs3.models.Student;

import java.util.List;

public interface StudentDAO {
    List<Student> getAllStudents();
    Student getStudentById(int id);
    void addStudent(Student student);
    void removeStudentById(int id);

}
