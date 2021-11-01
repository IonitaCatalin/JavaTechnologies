package com.jtechnologies.labs4.controllers;

import com.jtechnologies.labs4.dao.EnrolmentDAO;
import com.jtechnologies.labs4.dao.EnrolmentDAOImpl;
import com.jtechnologies.labs4.models.Enrolment;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

@ManagedBean(name = "EnrolmentBean", eager = false)
@RequestScoped
public class EnrolmentBean {

    private int id;

    private EnrolmentDAO enrolmentDAO;

    public EnrolmentBean() {
        enrolmentDAO = new EnrolmentDAOImpl();
    }

    public List<Enrolment> getEnrolments() {
        return enrolmentDAO.getEnrolments();
    }

    public void removeEnrolmentById() {
        enrolmentDAO.removeEnrolmentById(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
