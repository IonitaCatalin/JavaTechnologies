package com.jtechnologies.labs3.controllers;

import com.jtechnologies.labs3.dao.ExamDAO;
import com.jtechnologies.labs3.dao.ExamDAOImpl;
import com.jtechnologies.labs3.models.Exam;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

@ManagedBean(name = "ExamController", eager = false)
@RequestScoped
public class ExamControllerBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private ExamDAO examsDAO;
    String id;
    String duration;
    String subject;
    String starting;


    public ExamControllerBean() {
        examsDAO = new ExamDAOImpl();
    }

    public List<Exam> getAllExams() {
        try {
            return examsDAO.getAllExams();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Exam getExamById() {
        try {
            return examsDAO.getExamById(this.id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void removeExamById() {
        try {
            examsDAO.removeExamById(this.id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addExam() {
        try {
            examsDAO.addExam(new Exam(this.subject,this.starting,this.duration));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
