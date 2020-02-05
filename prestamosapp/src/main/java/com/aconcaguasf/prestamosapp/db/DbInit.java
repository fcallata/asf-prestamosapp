package com.aconcaguasf.prestamosapp.db;

import com.aconcaguasf.prestamosapp.model.dao.ConfiguracionDAO;
import com.aconcaguasf.prestamosapp.model.dao.PersonaDAO;
import com.aconcaguasf.prestamosapp.model.dao.UsuarioDAO;
import com.aconcaguasf.prestamosapp.model.dominio.Configuracion;
import com.aconcaguasf.prestamosapp.model.dominio.Persona;
import com.aconcaguasf.prestamosapp.model.dominio.Usuario;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Service
public class DbInit implements CommandLineRunner {
    private UsuarioDAO usuarioDAO;
    private PersonaDAO personaDAO;
    private ConfiguracionDAO configuracionDAO;
    private PasswordEncoder passwordEncoder;

    public DbInit(UsuarioDAO usuarioDAO, PasswordEncoder passwordEncoder, PersonaDAO personaDAO, ConfiguracionDAO configuracionDAO) {
        this.usuarioDAO = usuarioDAO;
        this.passwordEncoder = passwordEncoder;
        this.personaDAO = personaDAO;
        this.configuracionDAO = configuracionDAO;
    }

    @Override
    public void run(String... args) {
        //this.usuarioDAO.deleteAll();

        Usuario admin = new Usuario("admin",passwordEncoder.encode("admin123"),"USER","");

        List<Usuario> users = Arrays.asList(admin);

        // Guarda usuarios
        this.usuarioDAO.saveAll(users);

        //Creo personas de prueba
        Persona fabio = new Persona("31541622", "Fabio", "Callata", "Cala", "3884166441","3884166441");
        this.personaDAO.create(fabio);

        //Valor maximo para el prestamo 1 millon
        Configuracion configuracion = new Configuracion(new BigDecimal(1000000L));
        configuracionDAO.create(configuracion);
    }
}
