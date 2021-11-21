package com.jtechnologies.labs5.service;

import com.jtechnologies.labs5.exception.ExamInvalidDuration;
import com.jtechnologies.labs5.exception.ExamNotFoundException;
import com.jtechnologies.labs5.models.Exam;
import com.jtechnologies.labs5.models.Student;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
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

    public List<Exam> searchByCriteria(boolean subjectCriteria, String subject, boolean timeframeCriteria, String timeframe) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Exam> query = builder.createQuery(Exam.class);


        Root<Exam> root = query.from(Exam.class);

        if(subjectCriteria) {
            query.select(root).where(builder.equal(root.get("subject"),subject));
        }
        if(timeframeCriteria) {
            query.select(root).where(builder.equal(root.get("starting"),timeframe));
        }

        TypedQuery<Exam> tquery = em.createQuery(query);

        return tquery.getResultList();

    }


    public void removeExamById(int id) throws ExamNotFoundException {
        Exam exam = em.find(Exam.class,id);

        if(exam == null) {
            throw new ExamNotFoundException("Exam with id " + id + "cannot be found!");
        }
        em.remove(exam);
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
