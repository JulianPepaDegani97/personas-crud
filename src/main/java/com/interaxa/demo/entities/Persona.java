package com.interaxa.demo.entities;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
//@Table(name = "personas")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    //@Column(name = "nombre")
    private String nombre;
    //@Column(name = "apellido")
    private String apellido;
   // @Column(name = "dni")
    private Long dni;
   // @Column(name = "empleado")
    private boolean empleado;

    public Persona() {}

    public Persona(String nombre, String apellido, Long dni, boolean empleado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.empleado = empleado;
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
