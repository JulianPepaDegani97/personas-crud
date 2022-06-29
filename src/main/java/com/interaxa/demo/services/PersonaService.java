package com.interaxa.demo.services;

import com.interaxa.demo.entities.Persona;

import java.util.List;

public interface PersonaService {

    List<Persona> traerPersonas();

    Persona traerPersonaPorId(long id);

    void crearPersona(Persona persona);

    void eliminarPersona(long id);

    void activePersona(Persona persona);
}
