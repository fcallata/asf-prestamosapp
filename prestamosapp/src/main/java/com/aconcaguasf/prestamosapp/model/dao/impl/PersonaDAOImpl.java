package com.aconcaguasf.prestamosapp.model.dao.impl;

import com.aconcaguasf.prestamosapp.model.dao.PersonaDAO;
import com.aconcaguasf.prestamosapp.model.dao.base.impl.BaseGenericDaoImpl;
import com.aconcaguasf.prestamosapp.model.dominio.Persona;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Repository
public class PersonaDAOImpl extends BaseGenericDaoImpl<Persona> implements PersonaDAO {

    @Override
    public Persona findByNroIdentificacion(String nroIdentificacion) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Persona> criteriaQuery = criteriaBuilder.createQuery(Persona.class);
        Root<Persona> root = criteriaQuery.from(Persona.class);
        Predicate condition = criteriaBuilder.equal(root.get("nroIdentificacion"), nroIdentificacion);
        criteriaQuery.where(condition);
        TypedQuery<Persona> typedQuery = entityManager.createQuery(criteriaQuery);
        return typedQuery.getSingleResult();
    }
}
