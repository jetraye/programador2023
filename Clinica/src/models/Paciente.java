
package models;


public class Paciente {
    private int idPaciente;
    private String apellidos;
    private String nombres;
    private int edad;
    private int dni;
    private String celular;

    public Paciente(int idPaciente, String apellidos, String nombres, int edad, int dni, String celular) {
        this.idPaciente = idPaciente;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.edad = edad;
        this.dni = dni;
        this.celular = celular;
    }

    public Paciente() {
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
    
}
