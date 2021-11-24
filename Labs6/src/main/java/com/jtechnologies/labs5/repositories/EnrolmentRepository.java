package com.jtechnologies.labs5.repositories;

import com.jtechnologies.labs5.exception.*;
import com.jtechnologies.labs5.models.Enrolment;
import com.jtechnologies.labs5.models.Exam;
import com.jtechnologies.labs5.models.Student;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class EnrolmentRepository implements DataRepositoryInterface<Enrolment,Integer>{

    @PersistenceContext(unitName = "persistence/scheduler")
    EntityManager em;


    public List<Enrolment> getEnrolments() {
        return em.createNamedQuery("Enrolments.findAll",Enrolment.class).getResultList();
    }

    public Enrolment getEnrolmentById(int id) throws EnrolmentNotFoundException {
        return em.find(Enrolment.class,id);
    }

    public void updateEnrolment(int id, int studentId, int examId) throws EnrolmentNotFoundException {
        Enrolment enrolment = em.find(Enrolment.class,id);

        if(enrolment == null) {
            throw new EnrolmentNotFoundException("Enrolment with id " + id + "could not be found!");
        }

        em.createNamedQuery("Enrolments.updateEnrolment",Enrolment.class)
                .setParameter("examId", examId)
                .setParameter("enrolmentId", id)
                .executeUpdate();
    }

    @Override
    public Enrolment save(Enrolment enrolment) throws EnrolmentInvalidExamException,EnrolmentInvalidStudentException {
        Exam exam = em.find(Exam.class, enrolment.getExamId());
        Student student = em.find(Student.class, enrolment.getStudentId());

        if(exam == null) {
            throw new EnrolmentInvalidExamException("Exam's id for Enrolment is invalid!");
        }

        if(student == null) {
            throw new EnrolmentInvalidStudentException("Student's id for Enrolment is invalid!");
        }

        em.persist(enrolment);
        return enrolment;

    }

    @Override
    public Enrolment findById( Integer id) throws Exception {
        Enrolment enrolment = em.find(Enrolment.class,id);

        if(enrolment == null) {
            throw new EnrolmentNotFoundException("Enrolment with id " + id + "could not be found!");
        }

        return enrolment;
    }

    @Override
    public void deleteById(Integer id) throws EnrolmentNotFoundException {
        Enrolment enrolment = em.find(Enrolment.class,id);

        if(enrolment == null) {
            throw new EnrolmentNotFoundException("Enrolment with id " + id + "could not be found!");
        }
        em.remove(enrolment);
    }

    @Override
    public void delete(Enrolment enrolm) throws Exception {
        Enrolment enrolment = em.find(Enrolment.class, enrolm.getId());

        if(enrolment == null) {
            throw new EnrolmentNotFoundException("Enrolment with id " + enrolm.getId() + "could not be found!");
        }
        em.remove(enrolment);
    }

    @Override
    public long count() {
        return 0;
    }
}
