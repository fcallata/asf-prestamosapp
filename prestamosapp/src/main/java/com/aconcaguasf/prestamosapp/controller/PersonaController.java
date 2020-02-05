package com.aconcaguasf.prestamosapp.controller;

import com.aconcaguasf.prestamosapp.controller.base.BaseController;
import com.aconcaguasf.prestamosapp.model.dominio.Persona;
import com.aconcaguasf.prestamosapp.model.dto.PersonaDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonaController extends BaseController {

    private static final Logger logger = LogManager.getLogger(PersonaController.class);

    @GetMapping("/personas")
    public List<PersonaDTO> getPersonas(){
        logger.info("getPersonas: " );
        PersonaDTO personaDTO = null;
        List<PersonaDTO> listaDto = new ArrayList<>();
        List<Persona> personas = super.personaService.getAll();
        for ( Persona p : personas) {
            personaDTO = new PersonaDTO();
            personaDTO.setNombre(p.getNombre());
            personaDTO.setPrimerApellido(p.getPrimerApellido());
            personaDTO.setSegundoApellido(p.getSegundoApellido());
            personaDTO.setTelCasa(p.getTelCasa());
            personaDTO.setTelMovil(p.getTelMovil());
            listaDto.add(personaDTO);
        }

        return listaDto;
    }
}
