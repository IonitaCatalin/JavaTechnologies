package com.jtechnologies.labs4.beans;

import com.jtechnologies.labs4.dao.StudentDAO;
import com.jtechnologies.labs4.dao.StudentDAOImpl;
import com.jtechnologies.labs4.models.Student;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

@ManagedBean(name = "StudentBean", eager = false)
@RequestScoped
public class StudentBean {

    private int id;
    private final StudentDAO studentsDAO;

    public StudentBean() {
        studentsDAO = new StudentDAOImpl();
    }

    public List<Student> getStudents() {
        return studentsDAO.getStudents();
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
