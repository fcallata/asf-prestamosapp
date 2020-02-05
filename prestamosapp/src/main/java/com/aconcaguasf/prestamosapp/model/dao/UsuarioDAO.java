package com.aconcaguasf.prestamosapp.model.dao;

import com.aconcaguasf.prestamosapp.model.dao.base.BaseGenericDao;
import com.aconcaguasf.prestamosapp.model.dominio.Usuario;

public interface UsuarioDAO extends BaseGenericDao<Usuario> {

    Usuario findByNombre(String nombre);
}
