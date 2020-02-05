package com.aconcaguasf.prestamosapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.aconcaguasf.prestamosapp.service.ConfiguracionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class ConfiguracionServiceTest {

    @Autowired
    ConfiguracionService configuracionService;

    @Test
    void getMaximoValor(){
        BigDecimal valor = configuracionService.getValormaximo(1l);
        assertEquals(new BigDecimal("1000000"), configuracionService.getValormaximo(1l));
    }
}
