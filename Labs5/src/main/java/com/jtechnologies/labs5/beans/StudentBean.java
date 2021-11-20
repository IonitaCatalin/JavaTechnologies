package com.jtechnologies.labs5.beans;

import com.jtechnologies.labs5.service.StudentService;
import com.jtechnologies.labs5.models.Student;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@ManagedBean(name = "StudentBean", eager = false)
@RequestScoped
public class StudentBean {

    private int id;

    @Inject
    private StudentService studentService;

    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    public void removeStudentById() {
        studentService.removeStudentById(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
