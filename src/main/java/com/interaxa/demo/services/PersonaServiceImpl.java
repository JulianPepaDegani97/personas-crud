package com.interaxa.demo.services;


import com.interaxa.demo.dtos.PersonaDTO;
import com.interaxa.demo.entities.Persona;
import com.interaxa.demo.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    PersonaRepository personaRepository;

    @Override
    public List<Persona> traerPersonas() {
        return personaRepository.findAll();
    }

    @Override
    public Persona traerPersonaPorId(long id) {
        return personaRepository.findById(id).orElse(null);
    }

    Persona mapearPersona(PersonaDTO personaDTO) {
        Persona persona = new Persona();
        persona.setNombre(personaDTO.getNombre());
        persona.setApellido(personaDTO.getApellido());
        persona.setDni(personaDTO.getDni());
        persona.setEmpleado(personaDTO.isEmpleado());
        return persona;
    }

    Persona mapearPersona(PersonaDTO personaDTO, long id) {
        Persona persona = personaRepository.findById(id).orElse(null);
        persona.setNombre(personaDTO.getNombre());
        persona.setApellido(personaDTO.getApellido());
        persona.setDni(personaDTO.getDni());
        persona.setEmpleado(personaDTO.isEmpleado());
        return persona;
    }

    @Override
    public void crearPersona(PersonaDTO personaDTO) {
        personaRepository.save(mapearPersona(personaDTO));
    }

    @Override
    public void eliminarPersona(long id) {
        personaRepository.deleteById(id);
    }

    @Override
    public void actualizarPersona(PersonaDTO personaDTO, long id) {
          personaRepository.save(mapearPersona(personaDTO, id));
    }
}
