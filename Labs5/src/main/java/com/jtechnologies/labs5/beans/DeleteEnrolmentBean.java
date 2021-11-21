package com.jtechnologies.labs5.beans;

import com.jtechnologies.labs5.exception.EnrolmentNotFoundException;
import com.jtechnologies.labs5.service.EnrolmentService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

@ManagedBean(name = "DeleteEnrolmentBean", eager = false)
@RequestScoped
public class DeleteEnrolmentBean {

    private int enrolmentId;
    private String transactionResult;

    @Inject
    private EnrolmentService enrolmentService;

    public void removeEnrolmentById() {
        try {
            enrolmentService.removeEnrolmentById(enrolmentId);
            transactionResult = "Enrolment with id " + enrolmentId + " has been deleted successfully!";
        } catch (EnrolmentNotFoundException e) {
            transactionResult = e.getMessage();
        }
    }

    public String getTransactionResult() {
        return transactionResult;
    }

    public int getEnrolmentId() {
        return enrolmentId;
    }

    public void setEnrolmentId(int enrolmentId) {
        this.enrolmentId = enrolmentId;
    }
}
