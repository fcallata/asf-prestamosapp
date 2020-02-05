package com.aconcaguasf.prestamosapp.service.impl;

import com.aconcaguasf.prestamosapp.model.dao.PersonaDAO;
import com.aconcaguasf.prestamosapp.model.dominio.Persona;
import com.aconcaguasf.prestamosapp.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    PersonaDAO personaDAO;

    @Override
    public Persona findByNroIdentificacion(String nroIdentificacion) {
        return personaDAO.findByNroIdentificacion(nroIdentificacion);
    }

    @Override
    public List<Persona> getAll() {
        return personaDAO.getAll(Persona.class);
    }
}
