package com.javatech.labs8.repository;

import com.javatech.labs8.entity.Contest;

import javax.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped
public class ContestRepository extends CrudRepository<Contest, Long> {
    public List<Contest> getEntities() {
        return entityManager.createNamedQuery("Contest.findAll").getResultList();
    }
}


