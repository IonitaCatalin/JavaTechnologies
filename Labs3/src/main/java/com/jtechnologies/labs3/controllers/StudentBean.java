package com.jtechnologies.labs3.controllers;

import com.jtechnologies.labs3.dao.StudentDAO;
import com.jtechnologies.labs3.dao.StudentDAOImpl;
import com.jtechnologies.labs3.models.Student;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

@ManagedBean(name = "StudentBean ", eager = false)
@RequestScoped
public class StudentBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private StudentDAO studentsDAO;

    public StudentBean() {
        studentsDAO = new StudentDAOImpl();
    }

    public List<Student> getStudents() {
        return studentsDAO.getStudents();
    }

    public Student getStudentById(String id) {
        return studentsDAO.getStudentById(id);
    }

    public void removeStudentById(String id) {
        studentsDAO.removeStudentById(id);
    }


}
