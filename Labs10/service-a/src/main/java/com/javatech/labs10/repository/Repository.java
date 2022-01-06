package com.javatech.labs10.repository;

public interface Repository<T, ID> {
    T save(T obj);
    T findById(Class<T> tClass, ID id);
    boolean deleteById(Class<T> tClass, ID id);
    boolean delete(T obj);
}
