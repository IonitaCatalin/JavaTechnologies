package com.jtechnologies.labs5.repositories;

import javax.ejb.*;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

package com.jtechnologies.labs5.exception;;
import com.jtechnologies.labs5.models.Resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Singleton
@Startup
public class ResourceRepository implements DataRepositoryInterface<Resource,Integer> {

    @PersistenceContext(unitName = "persistence/scheduler")
    EntityManager em;

    Map<Integer, List<Resource>> availables;
    Map<Integer, List<Resource>> occupied;

    public ResourceRepository() {
        availables = new HashMap<>();
        occupied = new HashMap<>();
    }

    @PostConstruct
    private void init() {
        refresh();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void reserve(Integer examId,Resource resource)  {

    }

    public void remove(Resource resource) {

    }

    public void refresh() {

    }




    public Map<Integer, List<Resource>> getAvailableResources() {
        return availables;
    }

    public Map<Integer, List<Resource>> getOccupiedResources() {
        return occupied;
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
