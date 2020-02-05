package com.aconcaguasf.prestamosapp.model.dao.impl;

import com.aconcaguasf.prestamosapp.model.dao.UsuarioDAO;
import com.aconcaguasf.prestamosapp.model.dao.base.impl.BaseGenericDaoImpl;
import com.aconcaguasf.prestamosapp.model.dominio.Usuario;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Repository
public class UsuarioDAOImpl extends BaseGenericDaoImpl<Usuario> implements UsuarioDAO {


    @Override
    public Usuario findByNombre(String nombre) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Usuario> criteriaQuery = criteriaBuilder.createQuery(Usuario.class);
        Root<Usuario> usuarioRoot = criteriaQuery.from(Usuario.class);
        Predicate emailCondition = criteriaBuilder.equal(usuarioRoot.get("username"), nombre);
        criteriaQuery.where(emailCondition);
        TypedQuery<Usuario> typedQuery = entityManager.createQuery(criteriaQuery);
        return typedQuery.getSingleResult();
    }
}
