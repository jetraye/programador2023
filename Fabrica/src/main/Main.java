
package main;

import model.Conexion;
import views.Pantalla;


public class Main {


    public static void main(String[] args) {
        Conexion cn = new Conexion();
        cn.conectar();    
        Pantalla panta = new Pantalla();
        panta.setVisible(true);
    }
    }
