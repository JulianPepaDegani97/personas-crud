package com.interaxa.demo.services;


import com.interaxa.demo.dtos.PersonaDTO;
import com.interaxa.demo.entities.Persona;
import com.interaxa.demo.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    PersonaRepository personaRepository;

    @Override
    public List<PersonaDTO> traerPersonas() {
        return personaRepository.findAll().stream().map(PersonaDTO::new).collect(Collectors.toList());
    }

    @Override
    public void guardarPersona(Persona persona) {
        personaRepository.save(persona);
    }

    @Override
    public PersonaDTO traerPersonaPorId(Long id) {
        return new PersonaDTO(personaRepository.findById(id).orElse(null));
    }

    @Override
    public Persona mapearPersona(PersonaDTO personaDTO) {
        Persona persona = new Persona();
        persona.setNombre(personaDTO.getNombre());
        persona.setApellido(personaDTO.getApellido());
        persona.setDni(personaDTO.getDni());
        persona.setEmpleado(personaDTO.isEmpleado());
        return persona;
    }

    @Override
    public Persona mapearPersonaId(PersonaDTO personaDTO, Long id) {
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
    public void eliminarPersona(Long id) {
        personaRepository.deleteById(id);
    }

    @Override
    public void actualizarPersona(PersonaDTO personaDTO, Long id) {
          personaRepository.save(mapearPersonaId(personaDTO, id));
    }
}
