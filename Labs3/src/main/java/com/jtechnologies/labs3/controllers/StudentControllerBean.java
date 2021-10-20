package com.jtechnologies.labs3.controllers;

import com.jtechnologies.labs3.dao.StudentDAO;
import com.jtechnologies.labs3.dao.StudentDAOImpl;
import com.jtechnologies.labs3.models.Student;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

@ManagedBean(name = "StudentController", eager = false)
@RequestScoped
public class StudentControllerBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private StudentDAO studentsDAO;

    public StudentControllerBean() {
        studentsDAO = new StudentDAOImpl();
    }

    public List<Student> getAllStudents() {
        try {
            return studentsDAO.getAllStudents();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Student getStudentById(String id) {
        try {
            return studentsDAO.getStudentById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addStudent(Student student) {
        try {
            studentsDAO.addStudent(student);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeStudentById(String id) {
        try {
            studentsDAO.removeStudentById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
