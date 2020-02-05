package com.aconcaguasf.prestamosapp.model.dao.impl;

import com.aconcaguasf.prestamosapp.model.dao.ConfiguracionDAO;
import com.aconcaguasf.prestamosapp.model.dao.base.impl.BaseGenericDaoImpl;
import com.aconcaguasf.prestamosapp.model.dominio.Configuracion;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.math.BigDecimal;

@Repository
public class ConfiguracionDAOImpl extends BaseGenericDaoImpl<Configuracion> implements ConfiguracionDAO {

    @Override
    public BigDecimal getValormaximo(Long id) {
        Query query = entityManager.createQuery("SELECT c.valorMaximo FROM Configuracion c ");
        Object valor = query.getSingleResult();
        BigDecimal maximo = BigDecimal.valueOf(((Number) valor).longValue());
        return maximo;
    }
}
