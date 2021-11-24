package com.jtechnologies.labs5.repositories;

import java.io.Serializable;

public interface DataRepositoryInterface<T, ID extends Serializable> {
    T save(T obj);

    T findById(Class<T> tClass, ID id);

    void deleteById(Class<T> tClass, ID id);

    void delete(T obj);

    void update(T obj);

    long count();
}
