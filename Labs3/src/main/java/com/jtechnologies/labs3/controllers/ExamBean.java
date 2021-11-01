package com.jtechnologies.labs3.controllers;

import com.jtechnologies.labs3.dao.ExamDAO;
import com.jtechnologies.labs3.dao.ExamDAOImpl;
import com.jtechnologies.labs3.models.Exam;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

@ManagedBean(name = "ExamBean", eager = false)
@RequestScoped
public class ExamBean {

    private ExamDAO examDAO;
    private int id;

    public ExamBean() {
        examDAO = new ExamDAOImpl();
    }

    public List<Exam> getExams() {
        return examDAO.getExams();
    }

    public void removeExamById() {
        examDAO.removeExamById(this.id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
