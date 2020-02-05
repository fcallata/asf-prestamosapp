package com.aconcaguasf.prestamosapp.model.dao.base;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public interface BaseGenericDao<T> {

    T create(T vo);

    void update(T vo);

    void delete(T vo);

    T get(Class<T> vo, Serializable id);

    List<T> getAll(Class<T> clazz);

    void saveAll(Collection<T> collection);

    void deleteAll(Collection<T> collection);

    long nextVal(String secuencia);
}
