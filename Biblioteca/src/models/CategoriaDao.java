
package models;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;



public class CategoriaDao {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    public boolean agregarCategoria(Categoria categoria){
        String query = "INSERT INTO categoria(nombreCategoria) VALUES (?)";
        try {
            con = cn.conectar();
            pst=con.prepareStatement(query);
            pst.setString(1,categoria.getNombreCategoria());
            pst.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar la categoria"+e);
            return false;
        }
    }
    
    
    public boolean modificarCategoria(Categoria categoria){
        String query = "UPDATE categoria SET nombreCategoria=? WHERE idCategoria = ?";
        try {
            con = cn.conectar();
            pst = con.prepareStatement(query);
            pst.setString(1,categoria.getNombreCategoria());
            pst.execute();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al modificar la categoria"+e);
            return false;            
        }
    }      
    
        public boolean borrarCategoria(int idCategoria){
       String query= "DELETE FROM categoria WHERE idCategoria = " +idCategoria;
       try {
            con = cn.conectar();
            pst = con.prepareStatement(query);
            pst.execute();
            return true;          
       } 
       catch (Exception e)
       {
            JOptionPane.showMessageDialog(null, "No se puede eliminar una categoria que tenga relacion a otra tabla"+e);
            return false;        
       }
       } 
    
        public List listarCategoria (){
       List <Categoria> list_Categoria = new ArrayList();
       String query = "SELECT * FROM categoria ORDER BY nombreCategoria ASC ";
       try {
           con = cn.conectar();
           pst = con.prepareStatement(query);
           rs=pst.executeQuery();
           while (rs.next()){
               Categoria categoria = new Categoria();
               categoria.setIdCategoria(rs.getInt("idCategoria"));
               categoria.setNombreCategoria(rs.getString("nombreCategoria"));
               list_Categoria.add(categoria);
           }
       }
       catch (Exception e)
       {
               JOptionPane.showMessageDialog(null,e.toString());
       }
        return list_Categoria;       
       }
}
