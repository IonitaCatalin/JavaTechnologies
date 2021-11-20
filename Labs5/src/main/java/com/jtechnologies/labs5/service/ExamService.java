package com.jtechnologies.labs5.service;

import com.jtechnologies.labs5.models.Exam;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ExamService {

    @PersistenceContext(unitName = "persistence/scheduler")
    EntityManager em;


    public List<Exam> getExams() {
        return null;
    }


    public Exam getExamById(int id) {
        return null;
    }


    public void removeExamById(int id) {

    }


    public void addExam(Exam exam) {

    }
}
