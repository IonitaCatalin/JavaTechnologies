package com.jtechnologies.labs5.utils;

import com.jtechnologies.labs5.models.Resource;
import com.jtechnologies.labs5.repositories.ResourceRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class ResourceChecker {

    @Inject
    ResourceRepository resourceRepository;

    boolean checkAvailable(Resource resource) {
        List<Resource> resourceList = resourceRepository.getAvailableResources();
        return resourceList.contains(resource);
    }
}
