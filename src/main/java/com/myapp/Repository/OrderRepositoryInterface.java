package com.myapp.Repository;

import java.io.Serializable;
import java.util.List;

public interface OrderRepositoryInterface<T, Id extends Serializable> {
    public void persist(T entity);
    public void close();

    public void update(T entity);

    public T findById(Id id);

    public void delete(T entity);


    public List<T> findAll();

    public void deleteAll();
}