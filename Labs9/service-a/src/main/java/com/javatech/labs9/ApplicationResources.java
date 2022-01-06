package com.javatech.labs9;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class ApplicationResources {
    @Produces
    @PersistenceContext(unitName = "persistence/reviewer-micros-a")
    private EntityManager entityManager;
}