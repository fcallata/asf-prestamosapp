package com.aconcaguasf.prestamosapp.service;

import com.aconcaguasf.prestamosapp.model.dominio.Persona;

import java.util.List;

public interface PersonaService {

    Persona findByNroIdentificacion(String nroIdentificacion);

    List<Persona> getAll();
}
