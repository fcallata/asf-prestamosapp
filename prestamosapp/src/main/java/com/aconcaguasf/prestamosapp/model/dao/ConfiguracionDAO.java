package com.aconcaguasf.prestamosapp.model.dao;

import com.aconcaguasf.prestamosapp.model.dao.base.BaseGenericDao;
import com.aconcaguasf.prestamosapp.model.dominio.Configuracion;

import java.math.BigDecimal;

public interface ConfiguracionDAO extends BaseGenericDao<Configuracion> {

    BigDecimal getValormaximo(Long id);
}
