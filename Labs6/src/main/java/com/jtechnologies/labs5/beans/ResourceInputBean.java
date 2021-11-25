package com.jtechnologies.labs5.beans;

import com.jtechnologies.labs5.exception.ResourceNotFoundException;
import com.jtechnologies.labs5.exception.UnavailableResourceException;
import com.jtechnologies.labs5.models.Resource;
import com.jtechnologies.labs5.repositories.ResourceRepository;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "ResourceInputBean")
@SessionScoped
public class ResourceInputBean {
    @EJB
    ResourceRepository resourceRepository;
    private int examId;
    private String selectedResources;

    private String transactionResult;

//    public void submit() {
//
//        try {
//            resourceRepository.reserve(examId,resourceId);
//        } catch (UnavailableResourceException | ResourceNotFoundException e) {
//            transactionResult
//        }
//    }


    public ResourceRepository getResourceRepository() {
        return resourceRepository;
    }

    public void setResourceRepository(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public String getSelectedResources() {
        return selectedResources;
    }

    public void setSelectedResources(String selectedResources) {
        this.selectedResources = selectedResources;
    }

    public String getTransactionResult() {
        return transactionResult;
    }

    public void setTransactionResult(String transactionResult) {
        this.transactionResult = transactionResult;
    }
}
