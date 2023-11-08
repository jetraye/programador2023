
package main;

import models.Conexion;
import views.Pantalla;

public class Clinica {

    public static void main(String[] args) {

        Conexion cn = new Conexion();
        cn.conectar();
        Pantalla panta = new Pantalla();
        panta.setVisible(true);    
    }
    
}
