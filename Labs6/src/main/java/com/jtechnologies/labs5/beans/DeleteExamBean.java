package com.jtechnologies.labs5.beans;

import com.jtechnologies.labs5.exception.ExamNotFoundException;
import com.jtechnologies.labs5.repositories.ExamRepository;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

@ManagedBean(name = "UpdateStudentBean", eager = false)
@RequestScoped
public class DeleteExamBean {
    private int examId;
    private String transactionResult;

    @EJB
    private ExamRepository examRepository;

    public void removeExamById() {
        try {
            examRepository.deleteById(this.examId);
            transactionResult = "Exam with id " + examId + "has been deleted successfully!";
        } catch (ExamNotFoundException e) {
            transactionResult = e.getMessage();
        }
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public String getTransactionResult() {
        return transactionResult;
    }
}
