package com.jtechnologies.labs5.repositories;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TransactionAttribute;
import javax.annotation.PostConstruct;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import com.jtechnologies.labs5.models.Resource;

import java.util.ArrayList;
import java.util.List;

@Singleton
@Startup
public class ResourceRepository implements DataRepositoryInterface<Resource,Integer> {

    @Inject
    EntityManager entityManager;


    List<Resource> availableResources;

    @PostConstruct
    private void init() {
        refresh();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void reserveResource(Resource resource) throws Exception {
        if (!availableResources.contains(resource)) {
            throw new Exception("The selected resource is not longer available");
        }
        entityManager.merge(resource);
        availableResources.remove(resource);
    }

    public void refresh() {
//        List<Resource> resourceList = entityManager.createNamedQuery("Resource.findAll").getResultList();
//        availableResources = new ArrayList<>();
//        for (Resource resource :
//                resourceList) {
//            if (resource.getExam() == null) {
//                availableResources.add(resource);
//            }
//        }
    }

    public List<Resource> getAvailableResources() {
        return availableResources;
    }

    @Override
    public Resource save(Resource obj) {
        return null;
    }

    @Override
    public Resource findById(Class<Resource> resourceClass, Integer integer) {
        return null;
    }

    @Override
    public void deleteById(Class<Resource> resourceClass, Integer integer) {

    }

    @Override
    public void delete(Resource obj) {

    }

    @Override
    public void update(Resource obj) {

    }

    @Override
    public long count() {
        return 0;
    }
}
