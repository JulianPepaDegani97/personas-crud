package com.interaxa.demo.controllers;


import com.interaxa.demo.dtos.PersonaDTO;
import com.interaxa.demo.entities.Persona;
import com.interaxa.demo.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonaController {

    @Autowired
    PersonaService personaService;

    @PersistenceContext
    EntityManager entityManager;

    @GetMapping("/personas")
    public List<PersonaDTO> traerPersonas() {
        return personaService.traerPersonas();
    }

    @GetMapping("/personas/{id}")
    public PersonaDTO traerPersonaPorId(@PathVariable(value = "id") Long id) {
        return personaService.traerPersonaPorId(id);
    }

    @PostMapping("/personas")
    public ResponseEntity<Object> crearPersona(@RequestBody PersonaDTO personaDTO) {

        personaService.guardarPersona(personaService.mapearPersona(personaDTO));
        return new ResponseEntity<>("Persona creada", HttpStatus.CREATED);
    }

    @PutMapping("/personas/{id}")
    public ResponseEntity<Object> actualizarPersona(@RequestBody PersonaDTO personaDTO, @PathVariable(value = "id") Long id) {

        if(personaService.traerPersonaPorId(id) == null) {
            return new ResponseEntity<>("Persona no encontrada", HttpStatus.NOT_FOUND);
        }

        personaService.actualizarPersona(personaDTO, id);
        return new ResponseEntity<>("Persona actualizada", HttpStatus.OK);
    }

    @DeleteMapping("/personas/{id}")
    public ResponseEntity<Object> eliminarPersonaPorId(@PathVariable(value = "id") Long id) {

        if(personaService.traerPersonaPorId(id) == null) {
            return new ResponseEntity<>("Persona no encontrada", HttpStatus.NOT_FOUND);
        }

        personaService.eliminarPersona(id);
        return new ResponseEntity<>("Persona eliminada con éxito", HttpStatus.OK);
    }

}
