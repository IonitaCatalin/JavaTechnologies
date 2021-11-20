package com.jtechnologies.labs5.beans;


import com.jtechnologies.labs5.service.ExamService;
import com.jtechnologies.labs5.models.Exam;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@ManagedBean(name = "ExamBean", eager = false)
@RequestScoped
public class ExamBean {
    @Inject
    private ExamService examService;
    private int id;

    public ExamBean() {
    }

    public List<Exam> getExams() {
        return examService.getExams();
    }

    public void removeExamById() {
        examService.removeExamById(this.id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
