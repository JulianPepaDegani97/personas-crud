package com.interaxa.demo.controllers;


import com.interaxa.demo.dtos.PersonaDTO;
import com.interaxa.demo.entities.Persona;
import com.interaxa.demo.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "/api/personas")
public class PersonaController {

    @Autowired
    PersonaService personaService;

    @GetMapping("/")
    public List<Persona> traerPersonas() {
        return personaService.traerPersonas();
    }

    @GetMapping("/{id}")
    public Persona traerPersonaPorId(@PathVariable(value = "id") long id) {
        return personaService.traerPersonaPorId(id);
    }

    @PostMapping("/")
    public ResponseEntity<Object> crearPersona(PersonaDTO personaDTO) {

        if(personaDTO.getNombre().isEmpty() || personaDTO.getApellido().isEmpty() ||
        personaDTO.getDni() <= 0) {
            return  new ResponseEntity<>("Completar datos", HttpStatus.FORBIDDEN);
        }

        personaService.crearPersona(personaDTO);
        return new ResponseEntity<>("Persona creada", HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> actualizarPersona(PersonaDTO personaDTO, long id) {

        if(personaService.traerPersonaPorId(id) == null) {
            return new ResponseEntity<>("Persona no encontrada", HttpStatus.NOT_FOUND);
        }

        personaService.actualizarPersona(personaDTO, id);
        return new ResponseEntity<>("Persona actualizada", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminarPersonaPorId(long id) {

        if(personaService.traerPersonaPorId(id) == null) {
            return new ResponseEntity<>("Persona no encontrada", HttpStatus.NOT_FOUND);
        }

        personaService.eliminarPersona(id);
        return new ResponseEntity<>("Persona eliminada con éxito", HttpStatus.OK);
    }

}
