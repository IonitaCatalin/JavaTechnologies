package com.jtechnologies.labs5.beans;

import com.jtechnologies.labs5.exception.StudentConflictException;
import com.jtechnologies.labs5.service.StudentService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

@ManagedBean(name = "UpdateStudentBean", eager = false)
@RequestScoped
public class UpdateStudentBean {
    private int studentId;
    private String studentName;

    private String transactionResult;

    @Inject
    private StudentService studentService;

    public void updateStudent() {
        try {
            studentService.updateStudent(studentId,studentName);
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

    public StudentService getStudentService() {
        return studentService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public String getTransactionResult() {
        return transactionResult;
    }
}
