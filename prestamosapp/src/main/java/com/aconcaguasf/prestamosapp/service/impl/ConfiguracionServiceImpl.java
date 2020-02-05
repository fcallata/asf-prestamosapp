package com.aconcaguasf.prestamosapp.service.impl;

import com.aconcaguasf.prestamosapp.model.dao.ConfiguracionDAO;
import com.aconcaguasf.prestamosapp.service.ConfiguracionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ConfiguracionServiceImpl implements ConfiguracionService {

    @Autowired
    ConfiguracionDAO configuracionDAO;

    @Override
    public BigDecimal getValormaximo(Long id) {
        return configuracionDAO.getValormaximo(id);
    }
}
