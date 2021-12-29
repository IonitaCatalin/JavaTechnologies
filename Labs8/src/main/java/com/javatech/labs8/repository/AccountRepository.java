package com.javatech.labs8.repository;

import com.javatech.labs8.entity.Account;

import javax.enterprise.context.RequestScoped;
import javax.persistence.NoResultException;
import java.util.List;

@RequestScoped
public class AccountRepository extends CrudRepository<Account, Long> {
    public List<Account> getEntities() {
        List results = entityManager.createNamedQuery("User.findAll").getResultList();

        if(results == null) {
            return null;
        }
        return (List<Account>) results;

    }

    public Account getUserByName(String name) {
        Object result = entityManager.createNamedQuery("User.findByName")
                .setParameter(1, name)
                .getSingleResult();
        if(result == null)
        {
            return null;
        }

        return (Account) result;

    }

    public boolean checkIfExists(String name) {
        try{
            Object result = entityManager.createNamedQuery("User.findByName")
                    .setParameter(1, name)
                    .getSingleResult();
        } catch(NoResultException exception) {
            return false;
        }
        return true;
    }


}


