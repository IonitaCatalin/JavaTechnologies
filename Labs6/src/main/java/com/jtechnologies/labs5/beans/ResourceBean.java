package com.jtechnologies.labs5.beans;

import com.jtechnologies.labs5.repositories.ResourceRepository;
import com.jtechnologies.labs5.models.Resource;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean(name = "ResourcesBean", eager = true)
@SessionScoped
public class ResourceBean {
    @EJB
    ResourceRepository resourceRepository;

    public List<Resource> getAllResources() {
//        return resourceRepository.getAvailableResources();
        return null;
    }

}
