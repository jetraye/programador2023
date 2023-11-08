
package Main;


import models.Conexion;
import view.Vista;


public class Main {


    public static void main(String[] args) {
        Conexion con = new Conexion();
        con.conectar();
        Vista vist=new Vista();
        vist.setVisible(true);
    }
}
