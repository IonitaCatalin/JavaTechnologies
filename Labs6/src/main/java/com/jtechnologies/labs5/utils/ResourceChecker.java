package com.jtechnologies.labs5.utils;

import com.jtechnologies.labs5.models.Resource;
import com.jtechnologies.labs5.repositories.ResourceRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;
import java.util.Map;

@Stateful
public class ResourceChecker {

    @EJB
    ResourceRepository resourceRepository;

    boolean checkAvailable(Resource resource) {
        for(Map.Entry<Integer, List<Resource>> entry: resourceRepository.getOccupiedResources().entrySet()) {
            if(entry.getValue().contains(resource)) {
                return false;
            }
        }
        return true;
    }

//    boolean checkAvailable(Integer resourceId) {
//        for(Map.Entry<Integer, List<Resource>> entry: resourceRepository.getOccupiedResources().entrySet()) {
//            if(entry.getValue().contains(resource)) {
//                return false;
//            }
//        }
//        return true;
//    }
}
