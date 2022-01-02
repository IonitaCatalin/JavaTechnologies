package com.javatech.labs8;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class ApplicationResources {
    @Produces
    @PersistenceContext(unitName = "jdbc/reviewer-micros-b")
    private EntityManager entityManager;
}