package com.aconcaguasf.prestamosapp.service.impl;

import com.aconcaguasf.prestamosapp.constante.ConstantesPrestamo;
import com.aconcaguasf.prestamosapp.model.dao.ConfiguracionDAO;
import com.aconcaguasf.prestamosapp.model.dao.PersonaDAO;
import com.aconcaguasf.prestamosapp.model.dao.PrestamoDAO;
import com.aconcaguasf.prestamosapp.model.dominio.Configuracion;
import com.aconcaguasf.prestamosapp.model.dominio.Persona;
import com.aconcaguasf.prestamosapp.model.dominio.Prestamo;
import com.aconcaguasf.prestamosapp.service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.MathContext;
import java.util.List;

@Service
@Transactional
public class PrestamoServiceImpl implements PrestamoService {

    @Autowired
    private PrestamoDAO prestamoDAO;
    @Autowired
    private PersonaDAO personaDAO;
    @Autowired
    private ConfiguracionDAO configuracionDAO;

    @Override
    public Long getUltimoPrestamo() {
        return prestamoDAO.getUltimoPrestamo();
    }

    @Override
    public void save(Prestamo prestamo, Persona persona) {
        MathContext mc = new MathContext(2);

        prestamo.setPersona(persona);
        prestamoDAO.create(prestamo);
        Configuracion config = configuracionDAO.get(Configuracion.class, ConstantesPrestamo.ID_CONFIGURACION_VALOR_MAXIMO);
        config.setValorMaximo(config.getValorMaximo().subtract(prestamo.getValorPrestamo(), mc));
    }

    @Override
    public List<Prestamo> getAll() {
        return prestamoDAO.getAll(Prestamo.class);
    }

}
