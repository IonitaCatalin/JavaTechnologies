package com.jtechnologies.labs5.beans;

import com.jtechnologies.labs5.repositories.EnrolmentRepository;
import com.jtechnologies.labs5.models.Enrolment;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@ManagedBean(name = "EnrolmentBean", eager = false)
@RequestScoped
public class EnrolmentBean {

    private int id;

    @Inject
    private EnrolmentRepository enrolmentRepository;

    public List<Enrolment> getEnrolments() {
        return enrolmentRepository.getEnrolments();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
