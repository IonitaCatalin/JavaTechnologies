package com.jtechnologies.labs5.beans;

import com.jtechnologies.labs5.exception.EnrolmentNotFoundException;
import com.jtechnologies.labs5.service.EnrolmentService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

@ManagedBean(name = "DeleteEnrolmentBean", eager = false)
@RequestScoped
public class DeleteEnrolmentBean {

    @Inject
    private EnrolmentService enrolmentService;

    public void removeEnrolmentById(int id) {
        try {
            enrolmentService.removeEnrolmentById(id);
        } catch (EnrolmentNotFoundException e) {
            e.printStackTrace();
        }
    }
}
