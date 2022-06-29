package com.interaxa.demo.entities;


import javax.persistence.*;

@Entity
@Table(name = "personas")
public class persona {
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "id")
    private String apellido;
    @Column(name = "id")
    private long dni;
    @Column(name = "id")
    private boolean empleado;

    public persona() {}

    public persona(String nombre, String apellido, long dni, boolean empleado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.empleado = empleado;
    }

    public long getId() {return id;}

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getApellido() {return apellido;}
    public void setApellido(String apellido) {this.apellido = apellido;}

    public long getDni() {return dni;}
    public void setDni(long dni) {this.dni = dni;}

    public boolean isEmpleado() {return empleado;}
    public void setEmpleado(boolean empleado) {this.empleado = empleado;}


}
