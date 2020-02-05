package com.aconcaguasf.prestamosapp.service;

import com.aconcaguasf.prestamosapp.model.dominio.Persona;
import com.aconcaguasf.prestamosapp.model.dominio.Prestamo;

import java.util.List;

public interface PrestamoService {

    public Long getUltimoPrestamo();

    public void save(Prestamo prestamo, Persona persona);

    public List<Prestamo> getAll();
}
