package com.aconcaguasf.prestamosapp.controller.base;

import com.aconcaguasf.prestamosapp.service.ConfiguracionService;
import com.aconcaguasf.prestamosapp.service.PersonaService;
import com.aconcaguasf.prestamosapp.service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseController {

    @Autowired
    public PrestamoService prestamoService;
    @Autowired
    public PersonaService personaService;
    @Autowired
    public ConfiguracionService configuracionService;
}
