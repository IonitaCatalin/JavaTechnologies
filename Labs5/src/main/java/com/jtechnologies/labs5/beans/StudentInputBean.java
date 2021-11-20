package com.jtechnologies.labs5.beans;

import com.jtechnologies.labs5.service.StudentService;
import com.jtechnologies.labs5.models.Student;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

@ManagedBean(name = "StudentInputBean ", eager = false)
@RequestScoped
public class StudentInputBean {
    private String fullName;

    @Inject
    private StudentService studentService;


    public void submit() {
        studentService.addStudent(new Student(fullName));
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
