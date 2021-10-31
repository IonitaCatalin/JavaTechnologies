package com.jtechnologies.labs3.dao;

import com.jtechnologies.labs3.models.Enrolment;
import com.jtechnologies.labs3.models.Exam;

import java.util.List;

public interface EnrolmentDAO {

    List<Enrolment> getEnrolments() ;
    Exam getEnrolmentById(int id) ;
    void removeEnrolmentById(String id) ;
    void addEnrolment(Enrolment enrolment) ;
}
