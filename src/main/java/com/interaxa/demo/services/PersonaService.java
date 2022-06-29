package com.interaxa.demo.services;

import com.interaxa.demo.dtos.PersonaDTO;
import com.interaxa.demo.entities.Persona;

import java.util.List;

public interface PersonaService {

    List<Persona> traerPersonas();

    Persona traerPersonaPorId(long id);

    void crearPersona(PersonaDTO personaDTO);

    void eliminarPersona(long id);

    void actualizarPersona(PersonaDTO personaDTO, long id);
}
