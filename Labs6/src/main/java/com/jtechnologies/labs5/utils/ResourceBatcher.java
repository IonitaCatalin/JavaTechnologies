package com.jtechnologies.labs5.utils;

import com.jtechnologies.labs5.models.Resource;
import com.jtechnologies.labs5.repositories.ResourceRepository;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Remove;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import java.util.ArrayList;
import java.util.List;

public class ResourceBatcher {
    List<Resource> resourceList;

    @EJB
    ResourceRepository resourceRepository;

    @PostConstruct
    void init(){
        resourceList = new ArrayList<>();
    }

    public void addSelectedResource(Resource resource) {
        resourceList.add(resource);
    }

    @Remove
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public boolean reserveSelectedResources() {
        try {
            for (Resource resource :
                    resourceList) {
                resourceRepository.reserve(resource);
            }
            return true;
        } catch (Exception e) {
            resourceRepository.refresh();
            return false;
        }
    }
}
