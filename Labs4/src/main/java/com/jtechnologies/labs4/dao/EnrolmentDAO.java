package com.jtechnologies.labs4.dao;

import com.jtechnologies.labs4.models.Enrolment;
import com.jtechnologies.labs4.models.Exam;

import java.util.List;

public interface EnrolmentDAO {

    List<Enrolment> getEnrolments() ;
    Exam getEnrolmentById(int id) ;
    void removeEnrolmentById(int id) ;
    void addEnrolment(Enrolment enrolment) ;
}
