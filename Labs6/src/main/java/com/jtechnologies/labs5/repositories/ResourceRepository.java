package com.jtechnologies.labs5.repositories;

import javax.ejb.*;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jtechnologies.labs5.exception.UnreservableResourceException;
import com.jtechnologies.labs5.models.Resource;

import java.util.List;

@Singleton
@Startup
public class ResourceRepository implements DataRepositoryInterface<Resource,Integer> {

    @PersistenceContext(unitName = "persistence/scheduler")
    EntityManager em;

    List<Resource> resources;

    @PostConstruct
    private void init() {
        refresh();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void reserve(Resource resource) throws UnreservableResourceException {
        if (!resources.contains(resource)) {

            throw new UnreservableResourceException("The selected resource is not longer available");
        }
        em.merge(resource);
        resources.remove(resource);
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
        return resources;
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
