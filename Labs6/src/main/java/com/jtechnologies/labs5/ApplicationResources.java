package com.jtechnologies.labs5;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class ApplicationResources {
    @Produces
    @PersistenceContext(unitName = "persistence/scheduler")
    private EntityManager em;
}
