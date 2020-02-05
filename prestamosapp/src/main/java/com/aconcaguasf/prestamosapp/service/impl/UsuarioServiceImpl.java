package com.aconcaguasf.prestamosapp.service.impl;

import com.aconcaguasf.prestamosapp.model.dao.UsuarioDAO;
import com.aconcaguasf.prestamosapp.model.dominio.Usuario;
import com.aconcaguasf.prestamosapp.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioDAO usuarioDAO;

    @Override
    public List<Usuario> getAll() {
        return usuarioDAO.getAll(Usuario.class);
    }
}
