package com.javatech.labs8.repository;

import com.javatech.labs8.entity.User;

import javax.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped
public class UserRepository extends CrudRepository<User, Long> {
    public List<User> getEntities() {
        List resultList = entityManager.createNamedQuery("User.findAll").getResultList();
        return resultList;
    }

    public User getUserByName(String name) {
        return (User) entityManager.createNamedQuery("User.findByName").setParameter(1, name).getSingleResult();
    }
}


