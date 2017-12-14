package com.meknes.dao;

import java.util.List;

/**
 * Created by X-MART on 22/03/2017.
 */
public interface EntityRepository<T> {
    public T save(T p);
    public List<T> findAll();
    public List<T> findByDesignation(String mc);
    public T findIne(Integer id);
    public T update(T p);
    public void remove(Integer id);
}
