package com.jtechnologies.labs5.repositories;

import com.jtechnologies.labs5.exception.StudentNotFoundException;

import java.io.Serializable;

public interface DataRepositoryInterface<T, ID extends Serializable> {
    T save(T obj) throws Exception;

    T findById(ID id) throws Exception;

    void deleteById(ID id) throws Exception;

    void delete(T obj) throws Exception;

    long count();
}
