/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author cfp40
 */
public class Seccion {
    private int id_Seccion;
    private String nombre;

    public Seccion() {
    }

    public Seccion(int id_Seccion, String nombre) {
        this.id_Seccion = id_Seccion;
        this.nombre = nombre;
    }

    public int getId_Seccion() {
        return id_Seccion;
    }

    public void setId_Seccion(int id_Seccion) {
        this.id_Seccion = id_Seccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
