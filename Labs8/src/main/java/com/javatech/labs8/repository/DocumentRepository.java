package com.javatech.labs8.repository;

import com.javatech.labs8.entity.Document;

import javax.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped
public class DocumentRepository extends CrudRepository<Document, Long> {

    public List<Document> getEntities() {
        return entityManager.createNamedQuery("Document.findAll").getResultList();
    }
}


