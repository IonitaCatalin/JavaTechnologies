package com.jtechnologies.labs5.beans;

import com.jtechnologies.labs5.repositories.ResourceRepository;
import com.jtechnologies.labs5.models.Resource;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;
import java.util.Map;

@ManagedBean(name = "ResourcesBean")
@SessionScoped
public class ResourceBean {

    @EJB
    ResourceRepository resourceRepository;

    public Map<Integer, List<Resource>> getAllResources() {
        return resourceRepository.getOccupiedResources();
    }

    public List<Resource> getAllAvailableResources() {
        return resourceRepository.getAvailableResources();
    }

}
