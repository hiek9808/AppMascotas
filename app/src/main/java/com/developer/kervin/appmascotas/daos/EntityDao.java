package com.developer.kervin.appmascotas.daos;

import java.util.ArrayList;
import java.util.List;

public interface EntityDao<T> {

    public void create(T t);
    public void update(T t);
    public void delete(Object id);

    public T find(Object id);
    public ArrayList<T> findAll();
}
