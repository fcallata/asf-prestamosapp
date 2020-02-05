package com.aconcaguasf.prestamosapp.model.dao.impl;

import com.aconcaguasf.prestamosapp.model.dao.PrestamoDAO;
import com.aconcaguasf.prestamosapp.model.dao.base.impl.BaseGenericDaoImpl;
import com.aconcaguasf.prestamosapp.model.dominio.Persona;
import com.aconcaguasf.prestamosapp.model.dominio.Prestamo;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

@Repository
public class PrestamoDAOImpl extends BaseGenericDaoImpl<Prestamo> implements PrestamoDAO {

    @Override
    public Long getUltimoPrestamo() {

        Query query = entityManager.createQuery("SELECT max(p.idPrestamo) FROM Prestamo p ");
        Object valor = query.getSingleResult();

        Long devolver = ((valor != null)? ((Number) valor).longValue() + 1L : 1L);

        return devolver;
    }

}
