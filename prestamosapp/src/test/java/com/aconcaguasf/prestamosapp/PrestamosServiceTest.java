package com.aconcaguasf.prestamosapp;

import com.aconcaguasf.prestamosapp.service.PrestamoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PrestamosServiceTest {

    @Autowired
    PrestamoService prestamoService;

    @Test
    void testGetProximoNroPrestamo(){
        Long valor = prestamoService.getUltimoPrestamo();
        System.out.println("proximo nro: " + valor);
    }

    @Test
    void guardarPrestamo(){
        Long valor = prestamoService.getUltimoPrestamo();
        System.out.println("proximo nro: " + valor);
    }

}
