package com.interaxa.demo.dtos;

import com.interaxa.demo.entities.Persona;

public class PersonaDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private Long dni;
    private boolean empleado;

    public PersonaDTO() {}

    public PersonaDTO(String nombre, String apellido, Long dni, boolean empleado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.empleado = empleado;
    }

    public PersonaDTO(Persona persona) {
        this.id = persona.getId();
        this.nombre = persona.getNombre();
        this.apellido = persona.getApellido();
        this.dni = persona.getDni();
        this.empleado = persona.isEmpleado();
    }

    public Long getId() {return id;}

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getApellido() {return apellido;}
    public void setApellido(String apellido) {this.apellido = apellido;}

    public Long getDni() {return dni;}
    public void setDni(Long dni) {this.dni = dni;}

    public boolean isEmpleado() {return empleado;}
    public void setEmpleado(boolean empleado) {this.empleado = empleado;}
}
