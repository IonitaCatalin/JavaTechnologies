package com.jtechnologies.labs5.repositories;

import javax.ejb.*;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jtechnologies.labs5.enums.ResourceType;
import com.jtechnologies.labs5.exception.ResourceNotAllocatedException;
import com.jtechnologies.labs5.exception.ResourceNotFoundException;
import com.jtechnologies.labs5.exception.UnavailableResourceException;
import com.jtechnologies.labs5.models.Resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Singleton
@LocalBean
@Startup
public class ResourceRepository implements DataRepositoryInterface<Resource,Integer> {

    @PersistenceContext(unitName = "persistence/scheduler")
    EntityManager em;

    List<Resource> availables;
    Map<Integer, List<Resource>> occupied;

    public ResourceRepository() {
        availables = new ArrayList<>();
        occupied = new HashMap<>();

        int resourceId = 0;

        for(ResourceType rs: ResourceType.values()) {
            availables.add(new Resource(resourceId++,rs));
        }

    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void reserve(Integer examId,Resource resource) throws UnavailableResourceException {

        if(occupied.get(examId).contains(resource) || occupied.get(examId) == null) {
            throw new UnavailableResourceException("Resource you are trying to reserve is already reserved!");
        } else {
            occupied.computeIfAbsent(examId, k -> new ArrayList<>());
            occupied.get(examId).add(resource);

            if(availables.get(examId) != null) {
                availables.remove(resource);
            }

        }
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void reserve(Integer examId,Integer resourceId) throws UnavailableResourceException, ResourceNotFoundException {
        Resource resource = getAvailableResourceWithId(resourceId);

        if(resource == null) {
            throw new ResourceNotFoundException("Resource with id " + resourceId +" could not be found");
        }

        if(occupied.get(examId).contains(resource) || occupied.get(examId) == null) {
            throw new UnavailableResourceException("Resource you are trying to reserve is already reserved!");
        } else {
            occupied.computeIfAbsent(examId, k -> new ArrayList<>());
            occupied.get(examId).add(resource);

            if(availables.get(examId) != null) {
                availables.remove(resource);
            }

        }
    }

    public void remove(Integer examId,Resource resource) throws ResourceNotAllocatedException {
        if(!occupied.get(examId).contains(resource)) {
            throw new ResourceNotAllocatedException("Resource you are trying to free is not allocated!");
        } else {
            availables.add(resource);
            occupied.get(examId).add(resource);
        }
    }


    public List<Resource> getAvailableResources() {
        return availables;
    }

    public Map<Integer, List<Resource>> getOccupiedResources() {
        return occupied;
    }

    public Resource getAvailableResourceWithId(Integer resourceId) {
        for(Resource resource: availables) {
            if (resource.getId() == resourceId) {
                return resource;
            }
        }
        return null;
    }

    @Override
    public Resource save(Resource obj) {
        return null;
    }

    @Override
    public Resource findById(Integer integer) {
        return null;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Resource obj) {

    }


    @Override
    public long count() {
        return 0;
    }
}
