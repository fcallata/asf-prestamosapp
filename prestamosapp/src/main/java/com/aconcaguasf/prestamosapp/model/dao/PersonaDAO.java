package com.aconcaguasf.prestamosapp.model.dao;

import com.aconcaguasf.prestamosapp.model.dao.base.BaseGenericDao;
import com.aconcaguasf.prestamosapp.model.dominio.Persona;

public interface PersonaDAO extends BaseGenericDao<Persona> {

    public Persona findByNroIdentificacion(String nroIdentificacion);
}
