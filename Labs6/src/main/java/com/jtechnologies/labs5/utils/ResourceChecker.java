package com.jtechnologies.labs5.utils;

import com.jtechnologies.labs5.models.Resource;
import com.jtechnologies.labs5.repositories.ResourceRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class ResourceChecker {

    @EJB
    ResourceRepository resourceRepository;

    boolean checkAvailable(Resource resource) {

    }
}
