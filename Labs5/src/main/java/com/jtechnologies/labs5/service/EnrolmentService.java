package com.jtechnologies.labs5.service;

import com.jtechnologies.labs5.exception.EnrolmentInvalidExamException;
import com.jtechnologies.labs5.exception.EnrolmentInvalidStudentException;
import com.jtechnologies.labs5.exception.EnrolmentNotFoundException;
import com.jtechnologies.labs5.models.Enrolment;
import com.jtechnologies.labs5.models.Exam;
import com.jtechnologies.labs5.models.Student;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class EnrolmentService {

    @PersistenceContext(unitName = "persistence/scheduler")
    EntityManager em;


    public List<Enrolment> getEnrolments() {
        return em.createNamedQuery("Enrolments.findAll",Enrolment.class).getResultList();
    }

    public Enrolment getEnrolmentById(int id) throws EnrolmentNotFoundException {
        Enrolment enrolment = em.find(Enrolment.class,id);

        if(enrolment == null) {
            throw new EnrolmentNotFoundException("Enrolment with id " + id + "could not be found!");
        }

        return enrolment;
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

    public void removeEnrolmentById(int id) throws EnrolmentNotFoundException {
        Enrolment enrolment = em.find(Enrolment.class,id);

        if(enrolment == null) {
            throw new EnrolmentNotFoundException("Enrolment with id " + id + "could not be found!");
        }
        em.remove(enrolment);

    }

    public void addEnrolment(Enrolment enrolment) throws EnrolmentInvalidExamException, EnrolmentInvalidStudentException {
        Exam exam = em.find(Exam.class, enrolment.getExamId());
        Student student = em.find(Student.class, enrolment.getStudentId());

        if(exam == null) {
            throw new EnrolmentInvalidExamException("Exam's id for Enrolment is invalid!");
        }

        if(student == null) {
            throw new EnrolmentInvalidStudentException("Student's id for Enrolment is invalid!");
        }

        em.persist(enrolment);

    }
}
