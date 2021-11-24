package com.jtechnologies.labs5.beans;

import com.jtechnologies.labs5.exception.StudentConflictException;
import com.jtechnologies.labs5.repositories.StudentRepository;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

@ManagedBean(name = "UpdateStudentBean", eager = false)
@RequestScoped
public class UpdateStudentBean {
    @EJB
    private StudentRepository studentRepository;

    private int studentId;
    private String studentName;

    private String transactionResult;



    public void updateStudent() {
        try {
            studentRepository.updateStudent(studentId,studentName);
            transactionResult = "Student has been updated Successfully!";
        } catch (StudentConflictException e) {
            transactionResult = e.getMessage();
        }
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public StudentRepository getStudentService() {
        return studentRepository;
    }

    public void setStudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public String getTransactionResult() {
        return transactionResult;
    }
}
