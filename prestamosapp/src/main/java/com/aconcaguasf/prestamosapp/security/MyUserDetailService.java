package com.aconcaguasf.prestamosapp.security;

import com.aconcaguasf.prestamosapp.model.dao.UsuarioDAO;
import com.aconcaguasf.prestamosapp.model.dominio.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UsuarioDAO usuarioDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioDAO.findByNombre(username);

        return new MyUserPrincipal(usuario);
    }
}
