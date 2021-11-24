package com.jtechnologies.labs5.beans;

import com.jtechnologies.labs5.exception.StudentNotFoundException;
import com.jtechnologies.labs5.repositories.StudentRepository;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "DeleteStudentBean", eager = false)
@RequestScoped
public class DeleteStudentBean {
    private int studentId;
    private String transactionResult;

    @EJB
    private StudentRepository studentRepository;

    public void removeStudentById() {
        try {
            studentRepository.deleteById(studentId);
            transactionResult = "Student with id " + studentId + " has been deleted successfully!";
        } catch (StudentNotFoundException e) {
            transactionResult = e.getMessage();
        }
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getTransactionResult() {
        return transactionResult;
    }



}
