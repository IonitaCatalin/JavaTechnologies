package com.jtechnologies.labs3.controllers;

import com.jtechnologies.labs3.dao.EnrolmentDAO;
import com.jtechnologies.labs3.dao.EnrolmentDAOImpl;
import com.jtechnologies.labs3.models.Enrolment;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

@ManagedBean(name = "EnrolmentBean", eager = false)
@RequestScoped
public class EnrolmentBean {


    private EnrolmentDAO enrolmentDAO;

    public EnrolmentBean() {
        enrolmentDAO = new EnrolmentDAOImpl();
    }

    public List<Enrolment> getEnrolments() {
        return enrolmentDAO.getEnrolments();
    }
}
