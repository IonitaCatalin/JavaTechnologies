package com.jtechnologies.labs5.repositories;

import com.jtechnologies.labs5.exception.ExamInvalidDuration;
import com.jtechnologies.labs5.exception.ExamNotFoundException;
import com.jtechnologies.labs5.models.Exam;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@LocalBean
@Stateless
public class ExamRepository implements DataRepositoryInterface<Exam,Integer>{

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

    public void updateExam(int id,String subject,String starting,int duration) {


        em.createNamedQuery("Exam.updateExam", Exam.class)
                .setParameter("subject", subject)
                .setParameter("starting", starting)
                .setParameter("duration", duration)
                .setParameter("examId", id)
                .executeUpdate();
    }

    @Override
    public Exam save(Exam exam) throws ExamInvalidDuration {
        if(exam.getDuration() < 0 ) {
            throw new ExamInvalidDuration("Exam's duration cannot be negative!");
        }
        if(exam.getDuration() > 10) {
            throw new ExamInvalidDuration("Exam's duration cannot be bigger than 10 hours!");
        }
        em.persist(exam);
        return exam;
    }

    @Override
    public Exam findById(Integer id) throws ExamNotFoundException {
        Exam examFromDb = em.find(Exam.class, id);

        if(examFromDb == null) {
            throw new ExamNotFoundException("Exam with id " + id + "cannot be found");
        }

        return examFromDb;
    }

    @Override
    public void deleteById(Integer id) throws ExamNotFoundException {
        Exam exam = em.find(Exam.class,id);

        if(exam == null) {
            throw new ExamNotFoundException("Exam with id " + id + "cannot be found!");
        }
        em.remove(exam);
    }

    @Override
    public void delete(Exam exam) throws ExamNotFoundException {
        Exam examFromDb = em.find(Exam.class,exam.getId());

        if(examFromDb == null) {
            throw new ExamNotFoundException("Exam with id " + exam.getId() + "cannot be found!");
        }
        em.remove(examFromDb);
    }


    @Override
    public long count() {
        return 0;
    }
}
