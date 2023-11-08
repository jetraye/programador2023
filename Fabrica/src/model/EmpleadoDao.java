
package model;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class EmpleadoDao {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    
        public boolean agregarEmpleado(Empleado empleado){
        String query = "INSERT INTO empleado(apellido_Empleado,nombre_Empleado,dni_Empleado,seccion_Empleado) VALUES (?,?,?,?)";
        try {
            con = cn.conectar();
            pst=con.prepareStatement(query);
            pst.setString(1,empleado.getApellido()); 
            pst.setString(2,empleado.getNombre());
            pst.setInt(3,empleado.getDni());
            pst.setInt(4,empleado.getSeccion());
            pst.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar el empleado"+e);
            return false;
        }
    }
    
    
        public boolean modificarEmpleado(Empleado empleado){
        String query = "UPDATE empleado SET apellido_Empleado=?,nombre_Empleado=?,dni_Empleado=?,seccion_Empleado=? WHERE id_Empleado = ?";
        try {
            con = cn.conectar();
            pst = con.prepareStatement(query);
            pst.setString(1,empleado.getApellido());
            pst.setString(2,empleado.getNombre());
            pst.setInt(3,empleado.getDni());
            pst.setInt(4,empleado.getSeccion());
            pst.execute();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al modificar el empleado"+e);
            return false;            
        }
    }      
    
        public boolean borrarEmpleado(int id_Empleado){
       String query= "DELETE FROM empleado WHERE id_Empleado = " +id_Empleado;
       try {
            con = cn.conectar();
            pst = con.prepareStatement(query);
            pst.execute();
            return true;          
       } 
       catch (Exception e)
       {
            JOptionPane.showMessageDialog(null, "No se puede eliminar un empleado que tenga relacion a otra tabla"+e);
            return false;        
       }
       } 
    
        public List listarEmpleado (){
       List <Empleado> list_Empleado = new ArrayList();
       String query = "SELECT * FROM empleado ORDER BY nombre_Empleado ASC ";
       try {
           con = cn.conectar();
           pst = con.prepareStatement(query);
           rs=pst.executeQuery();
           while (rs.next()){
               Empleado empleado = new Empleado();
               empleado.setId_Empleado(rs.getInt("id_Empleado"));
               empleado.setApellido(rs.getString("apellido_Empleado"));
               empleado.setNombre(rs.getString("nombre_Empleado"));
               empleado.setDni(rs.getInt("dni_Empleado"));
               empleado.setSeccion(rs.getInt("seccion_Empleado"));
               list_Empleado.add(empleado);
           }
       }
       catch (Exception e)
       {
               JOptionPane.showMessageDialog(null,e.toString());
       }
        return list_Empleado;       
       }
    
    
    
    
}
