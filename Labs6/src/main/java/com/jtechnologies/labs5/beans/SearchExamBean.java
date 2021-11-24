package com.jtechnologies.labs5.beans;

import com.jtechnologies.labs5.models.Exam;
import com.jtechnologies.labs5.repositories.ExamRepository;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import java.util.List;

@ManagedBean(name = "SearchExamBean", eager = true)
@SessionScoped
public class SearchExamBean {

    @EJB
    private ExamRepository examRepository;

    private String transactionResult;
    private boolean examSubjectCriteria;
    private boolean timeframeCriteria;

    private String examSubject;
    private String timeFrame;

    private List<Exam> criteriaSearchResult;



    public void searchForExamByCriteria() {
        transactionResult = "Searched succesfully!";
        criteriaSearchResult = examRepository.searchByCriteria(examSubjectCriteria,examSubject,timeframeCriteria,timeFrame);
    }

    public String getTransactionResult() {
        return transactionResult;
    }


    public String getExamSubject() {
        return examSubject;
    }

    public void setExamSubject(String examSubject) {
        this.examSubject = examSubject;
    }

    public boolean isExamSubjectCriteria() {
        return examSubjectCriteria;
    }

    public void setExamSubjectCriteria(boolean examSubjectCriteria) {
        this.examSubjectCriteria = examSubjectCriteria;
    }


    public boolean isTimeframeCriteria() {
        return timeframeCriteria;
    }

    public void setTimeframeCriteria(boolean timeframeCriteria) {
        this.timeframeCriteria = timeframeCriteria;
    }

    public String getTimeFrame() {
        return timeFrame;
    }

    public void setTimeFrame(String timeFrame) {
        this.timeFrame = timeFrame;
    }

    public List<Exam> getCriteriaSearchResults() {
        return criteriaSearchResult;
    }

    public void setCriteriaSearchResult(List<Exam> criteriaSearchResult) {
        this.criteriaSearchResult = criteriaSearchResult;
    }
}
