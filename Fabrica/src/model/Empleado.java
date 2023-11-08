
package model;


public class Empleado {
    
    private int id_Empleado;
    private String apellido;
    private String nombre;
    private int dni;
    private int seccion;

    public Empleado() {
    }

    public Empleado(int id_Empleado, String apellido, String nombre, int dni, int seccion) {
        this.id_Empleado = id_Empleado;
        this.apellido = apellido;
        this.nombre = nombre;
        this.dni = dni;
        this.seccion = seccion;
    }

    public int getId_Empleado() {
        return id_Empleado;
    }

    public void setId_Empleado(int id_Empleado) {
        this.id_Empleado = id_Empleado;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getSeccion() {
        return seccion;
    }

    public void setSeccion(int seccion) {
        this.seccion = seccion;
    }

    
}
