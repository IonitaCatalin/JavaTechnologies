package com.jtechnologies.labs5.beans;


import com.jtechnologies.labs5.repositories.ExamRepository;
import com.jtechnologies.labs5.models.Exam;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@ManagedBean(name = "ExamBean", eager = false)
@RequestScoped
public class ExamBean {

    @EJB
    private ExamRepository examRepository;
    private int id;

    public ExamBean() {
    }

    public List<Exam> getExams() {
        return examRepository.getExams();
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
