package com.javatech.labs8.repository;

import com.javatech.labs8.entity.Account;

import javax.enterprise.context.RequestScoped;
import javax.persistence.NoResultException;
import java.util.List;

@RequestScoped
public class AccountRepository extends CrudRepository<Account, Long> {


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
        Long count = (Long) entityManager.createNamedQuery("User.countByName")
                .setParameter(1, name)
                .getSingleResult();
        return !count.equals(0L);
    }

    public boolean checkIfExistsById(Long id) {
        Long count = (Long)entityManager.createNamedQuery("User.countById")
                .setParameter(1,id)
                .getSingleResult();
        return !count.equals(0L);
    }


}


