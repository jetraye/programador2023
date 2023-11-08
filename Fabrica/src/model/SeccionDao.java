
package model;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class SeccionDao {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    
    
            public boolean agregarSeccion(Seccion seccion){
        String query = "INSERT INTO seccion(nombre_Seccion) VALUES (?)";
        try {
            con = cn.conectar();
            pst=con.prepareStatement(query);
            pst.setString(1,seccion.getNombre());
            pst.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar la seccion"+e);
            return false;
        }
    }
    
    
        public boolean modificarSeccion(Seccion seccion){
        String query = "UPDATE seccion SET nombre_Seccion=? WHERE id_Seccion = ?";
        try {
            con = cn.conectar();
            pst = con.prepareStatement(query);
            pst.setString(1,seccion.getNombre());
            pst.execute();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al modificar la seccion"+e);
            return false;            
        }
    }      
    
        public boolean borrarSeccion(int id_Seccion){
       String query= "DELETE FROM seccion WHERE id_Seccion = " +id_Seccion;
       try {
            con = cn.conectar();
            pst = con.prepareStatement(query);
            pst.execute();
            return true;          
       } 
       catch (Exception e)
       {
            JOptionPane.showMessageDialog(null, "No se puede eliminar una seccion que tenga relacion a otra tabla"+e);
            return false;        
       }
       } 
    
        public List listarSeccion (){
       List <Seccion> list_Seccion = new ArrayList();
       String query = "SELECT * FROM seccion ORDER BY id_Seccion ASC ";
       try {
           con = cn.conectar();
           pst = con.prepareStatement(query);
           rs=pst.executeQuery();
           while (rs.next()){
               Seccion seccion = new Seccion();
               seccion.setId_Seccion(rs.getInt("id_Seccion"));
               seccion.setNombre(rs.getString("nombre_Seccion"));
               list_Seccion.add(seccion);
           }
       }
       catch (Exception e)
       {
               JOptionPane.showMessageDialog(null,e.toString());
       }
        return list_Seccion;       
       }
}
