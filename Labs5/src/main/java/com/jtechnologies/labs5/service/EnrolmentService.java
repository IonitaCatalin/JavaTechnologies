package com.jtechnologies.labs5.service;

import com.jtechnologies.labs5.models.Enrolment;
import com.jtechnologies.labs5.models.Exam;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class EnrolmentService {

    @PersistenceContext(unitName = "persistence/scheduler")
    EntityManager em;


    public List<Enrolment> getEnrolments() {
        return null;
    }

    public Exam getEnrolmentById(int id) {
        return null;
    }


    public void removeEnrolmentById(int id) {

    }

    public void addEnrolment(Enrolment enrolment) {

    }
}
