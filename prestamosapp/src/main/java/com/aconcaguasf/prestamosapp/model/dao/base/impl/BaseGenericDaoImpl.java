package com.aconcaguasf.prestamosapp.model.dao.base.impl;

import com.aconcaguasf.prestamosapp.model.dao.base.BaseGenericDao;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Transactional
public class BaseGenericDaoImpl <T> implements BaseGenericDao <T> {

    @PersistenceContext
    protected EntityManager entityManager;

    public T create(T vo) {
        entityManager.persist(vo);
        entityManager.flush();
        return vo;
    }

    public void update(T vo) {
        entityManager.merge(vo);
        entityManager.flush();
    }

    public void delete(T vo) {
        entityManager.remove(entityManager.contains(vo) ? vo : entityManager.merge(vo));
    }

    public T get(Class<T> vo, Serializable id) {
        return entityManager.find(vo, id);
    }

    public List<T> getAll(Class<T> clazz) {
        CriteriaBuilder cb =  entityManager.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(clazz);
        cq.select(cq.from(clazz));
        TypedQuery<T> q = entityManager.createQuery(cq);
        return q.getResultList();
    }

    public void saveAll(Collection<T> collection) {

        for (T t: collection  ) {
            entityManager.persist(t);
            entityManager.flush();
        }
    }

    public void deleteAll(Collection<T> collection) {

    }

    public long nextVal(String secuencia) {
        return 0;
    }
}
