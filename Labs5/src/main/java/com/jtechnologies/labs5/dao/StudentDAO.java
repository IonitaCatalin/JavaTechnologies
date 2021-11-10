package com.jtechnologies.labs5.dao;

import com.jtechnologies.labs5.models.Student;

import java.util.List;

public interface StudentDAO {
    List<Student> getStudents();
    Student getStudentById(int id);
    void addStudent(Student student);
    void removeStudentById(int id);

}
