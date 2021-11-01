package com.jtechnologies.labs3.controllers;

import com.jtechnologies.labs3.dao.StudentDAO;
import com.jtechnologies.labs3.dao.StudentDAOImpl;
import com.jtechnologies.labs3.models.Student;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

@ManagedBean(name = "StudentBean ", eager = false)
@RequestScoped
public class StudentBean {

    private int id;
    private StudentDAO studentsDAO;

    public StudentBean() {
        studentsDAO = new StudentDAOImpl();
    }

    public List<Student> getStudents() {
        return studentsDAO.getStudents();
    }

    public Student getStudentById() {
        return studentsDAO.getStudentById(id);
    }

    public void removeStudentById() {
        studentsDAO.removeStudentById(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
