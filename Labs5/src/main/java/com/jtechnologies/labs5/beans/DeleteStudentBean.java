package com.jtechnologies.labs5.beans;

import com.jtechnologies.labs5.exception.StudentNotFoundException;
import com.jtechnologies.labs5.service.StudentService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

@ManagedBean(name = "DeleteStudentBean", eager = false)
@RequestScoped
public class DeleteStudentBean {
    private int id;
    private String transactionResult;

    @Inject
    private StudentService studentService;

    public void removeStudentById() {
        try {
            studentService.removeStudentById(id);
            transactionResult = "Student with id " + id + " has been deleted successfully!";
        } catch (StudentNotFoundException e) {
            transactionResult = e.getMessage();
        }
    }
}
