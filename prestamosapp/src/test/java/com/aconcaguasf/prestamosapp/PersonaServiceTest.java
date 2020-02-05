package com.aconcaguasf.prestamosapp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.aconcaguasf.prestamosapp.model.dominio.Persona;
import com.aconcaguasf.prestamosapp.service.PersonaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PersonaServiceTest {

    @Autowired
    PersonaService personaService;

    @Test
    void testGetProximoNroPrestamo(){
        Persona persona = personaService.findByNroIdentificacion("31541622");
        System.out.println("persona nomnbre: " + persona.getNombre());
        assertEquals("fabio", persona.getNombre().toLowerCase());
    }

}
