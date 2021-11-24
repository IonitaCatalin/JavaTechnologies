package com.jtechnologies.labs5.beans;

import com.jtechnologies.labs5.exception.StudentConflictException;
import com.jtechnologies.labs5.repositories.StudentRepository;
import com.jtechnologies.labs5.models.Student;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

@ManagedBean(name = "StudentInputBean ", eager = false)
@RequestScoped
public class StudentInputBean {
    private String name;

    @EJB
    private StudentRepository studentRepository;
    private String transactionResult;


    public void submit() {
        try {
            studentRepository.save(new Student(name));
            transactionResult = "Student with name " + name + " has been added successfully!";
        } catch (StudentConflictException e) {
            transactionResult = e.getMessage();
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTransactionResult() {
        return transactionResult;
    }

}
