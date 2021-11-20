package com.jtechnologies.labs5.service;

import com.jtechnologies.labs5.exception.ExamInvalidDuration;
import com.jtechnologies.labs5.exception.ExamNotFoundException;
import com.jtechnologies.labs5.models.Exam;
import com.jtechnologies.labs5.models.Student;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ExamService {

    @PersistenceContext(unitName = "persistence/scheduler")
    EntityManager em;


    public List<Exam> getExams() {
        return em.createNamedQuery("Exam.findAll",Exam.class).getResultList();
    }


    public Exam getExamById(int id) throws ExamNotFoundException {
        Exam examFromDb = em.find(Exam.class, id);

        if(examFromDb == null) {
            throw new ExamNotFoundException("Exam with id " + id + "cannot be found");
        }

        return examFromDb;

    }


    public void removeExamById(int id) {

    }

    public void addExam(Exam exam) throws ExamInvalidDuration {
        if(exam.getDuration() < 0 ) {
            throw new ExamInvalidDuration("Exam's duration cannot be negative!");
        }
        if(exam.getDuration() > 10) {
            throw new ExamInvalidDuration("Exam's duration cannot be bigger than 10 hours!");
        }
        em.persist(exam);
    }

    public void updateExam(int id,String subject,String starting,int duration) {


        em.createNamedQuery("Exam.updateExam", Exam.class)
                .setParameter("subject", subject)
                .setParameter("starting", starting)
                .setParameter("duration", duration)
                .setParameter("examId", id)
                .executeUpdate();
    }
}
