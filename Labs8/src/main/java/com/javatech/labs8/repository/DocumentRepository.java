package com.javatech.labs8.repository;

import com.javatech.labs8.entity.Document;

import javax.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped
public class DocumentRepository extends CrudRepository<Document, Long> {

    public boolean checkIfExists(String name) {
        Long count = (Long) entityManager.createNamedQuery("Document.countByName")
                .setParameter(1, name)
                .getSingleResult();
        return !count.equals(0L);
    }

    public boolean checkIfExistsById(Long id) {
        Long count = (Long)entityManager.createNamedQuery("Document.countById")
                .setParameter(1,id)
                .getSingleResult();
        return !count.equals(0L);
    }

}


