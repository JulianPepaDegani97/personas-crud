package main.java.com.interaxa.demo.entities;

public class persona {
    private long id;
    private String name;
    private String apellido;
    private long dni;
    private boolean empleado;



    public long getId() {return id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getApellido() {return apellido;}
    public void setApellido(String apellido) {this.apellido = apellido;}

    public long getDni() {return dni;}
    public void setDni(long dni) {this.dni = dni;}

    public boolean isEmpleado() {return empleado;}
    public void setEmpleado(boolean empleado) {this.empleado = empleado;}

}
