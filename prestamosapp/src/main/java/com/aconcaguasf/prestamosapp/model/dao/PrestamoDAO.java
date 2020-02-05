package com.aconcaguasf.prestamosapp.model.dao;

import com.aconcaguasf.prestamosapp.model.dao.base.BaseGenericDao;
import com.aconcaguasf.prestamosapp.model.dominio.Persona;
import com.aconcaguasf.prestamosapp.model.dominio.Prestamo;
import com.aconcaguasf.prestamosapp.model.dominio.Usuario;

public interface PrestamoDAO extends BaseGenericDao<Prestamo> {

    public Long getUltimoPrestamo();
}
