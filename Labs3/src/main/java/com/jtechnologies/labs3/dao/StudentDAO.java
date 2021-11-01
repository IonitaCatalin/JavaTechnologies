package com.jtechnologies.labs3.dao;

import com.jtechnologies.labs3.models.Student;

import java.util.List;

public interface StudentDAO {
    List<Student> getStudents();
    Student getStudentById(int id);
    void addStudent(Student student);
    void removeStudentById(int id);

}
