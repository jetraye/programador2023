
package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class PacienteDao {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    public boolean agregarPaciente(Paciente paciente){
        String query = "INSERT INTO paciente(apellidos,nombres,edad,dni,celular) VALUES (?,?,?,?,?)";
        try {
            con = cn.conectar();
            pst=con.prepareStatement(query);
            pst.setString(1,paciente.getApellidos());
            pst.setString(2,paciente.getNombres());
            pst.setInt(3,paciente.getEdad());
            pst.setInt(4,paciente.getDni());
            pst.setString(5,paciente.getCelular());
            pst.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar el paciente"+e);
            return false;
        }
    }
    
    
    public boolean modificarPaciente(Paciente paciente){
        String query = "UPDATE paciente SET apellidos=?,nombres=?,edad=?,dni=?,celular=? WHERE idPaciente = ?";
        try {
            con = cn.conectar();
            pst = con.prepareStatement(query);
            pst.setString(1,paciente.getApellidos());
            pst.setString(2,paciente.getNombres());
            pst.setInt(3,paciente.getEdad());
            pst.setInt(4,paciente.getDni());
            pst.setString(5,paciente.getCelular());
            pst.setInt(6,paciente.getIdPaciente());
            pst.execute();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al modificar el paciente"+e);
            return false;            
        }
    }      
    
        public boolean borrarPaciente(int idPaciente){
       String query= "DELETE FROM paciente WHERE idPaciente = " +idPaciente;
       try {
            con = cn.conectar();
            pst = con.prepareStatement(query);
            pst.execute();
            return true;          
       } 
       catch (Exception e)
       {
            JOptionPane.showMessageDialog(null, "No se puede eliminar un paciente que tenga relacion a otra tabla"+e);
            return false;        
       }
       } 
    
        public List listarPacientes (){
       List <Paciente> list_Paciente = new ArrayList();
       String query = "SELECT * FROM paciente ORDER BY apellidos ASC ";
       try {
           con = cn.conectar();
           pst = con.prepareStatement(query);
           rs=pst.executeQuery();
           while (rs.next()){
               Paciente paciente = new Paciente();
               paciente.setIdPaciente(rs.getInt("idPaciente"));
               paciente.setApellidos(rs.getString("apellidos"));
               paciente.setNombres(rs.getString("nombres"));
               paciente.setEdad(rs.getInt("edad"));
               paciente.setDni(rs.getInt("dni"));
               paciente.setCelular(rs.getString("celular"));
               list_Paciente.add(paciente);
           }
       }
       catch (Exception e)
       {
               JOptionPane.showMessageDialog(null,e.toString());
       }
        return list_Paciente;       
       } 
}
