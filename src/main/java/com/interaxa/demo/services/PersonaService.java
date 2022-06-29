package com.interaxa.demo.services;

import com.interaxa.demo.dtos.PersonaDTO;
import com.interaxa.demo.entities.Persona;

import java.util.List;

public interface PersonaService {

    List<PersonaDTO> traerPersonas();

    void guardarPersona(Persona persona);

    PersonaDTO traerPersonaPorId(Long id);

    Persona mapearPersona(PersonaDTO personaDTO);

    Persona mapearPersonaId(PersonaDTO personaDTO, Long id);

    void crearPersona(PersonaDTO personaDTO);

    void eliminarPersona(Long id);

    void actualizarPersona(PersonaDTO personaDTO, Long id);


}
