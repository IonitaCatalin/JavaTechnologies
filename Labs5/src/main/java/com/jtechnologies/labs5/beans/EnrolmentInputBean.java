package com.jtechnologies.labs5.beans;

import com.jtechnologies.labs5.dao.EnrolmentDAO;
import com.jtechnologies.labs5.dao.EnrolmentDAOImpl;
import com.jtechnologies.labs5.models.Enrolment;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "EnrolmentInputBean", eager = false)
@RequestScoped
public class EnrolmentInputBean {

//    private int studentId;
//    private int examId;
//
//    private final EnrolmentDAO enrolmentDAO;
//
//    public EnrolmentInputBean() {
//        enrolmentDAO = new EnrolmentDAOImpl();
//    }
//
//    public void submit() {
//        enrolmentDAO.addEnrolment(new Enrolment(studentId,examId));
//    }
//
//    public int getStudentId() {
//        return studentId;
//    }
//
//    public int getExamId() {
//        return examId;
//    }
//
//    public void setStudentId(int studentId) {
//        this.studentId = studentId;
//    }
//
//    public void setExamId(int examId) {
//        this.examId = examId;
//    }
}
