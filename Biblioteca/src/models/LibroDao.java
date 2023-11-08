
package models;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class LibroDao {
        Conexion cn = new Conexion();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    
            public boolean agregarLibro(Libro libro){
        String query = "INSERT INTO libro(tituloLibro,autorLibro,categoriaLibro) VALUES (?,?,?)";
        try {
            con = cn.conectar();
            pst=con.prepareStatement(query);
            pst.setString(1,libro.getTitulo()); 
            pst.setString(2,libro.getAutor());
            pst.setInt(3,libro.getIdCategoria());
            pst.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar el libro"+e);
            return false;
        }
    }
    
    
        public boolean modificarLibro(Libro libro){
        String query = "UPDATE libro SET tituloLibro=?,autorLibro=?,categoriaLibro=? WHERE idLibro = ?";
        try {
            con = cn.conectar();
            pst = con.prepareStatement(query);
            pst.setString(1,libro.getTitulo());
            pst.setString(2,libro.getAutor());
            pst.setInt(3,libro.getIdCategoria());
            pst.execute();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al modificar el libro"+e);
            return false;            
        }
    }      
    
        public boolean borrarLibro(int idLibro){
       String query= "DELETE FROM libro WHERE idLibro = " +idLibro;
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
    
        public List listarLibro (){
       List <Libro> list_Libro = new ArrayList();
       String query = "SELECT * FROM libro ORDER BY tituloLibro ASC ";
       try {
           con = cn.conectar();
           pst = con.prepareStatement(query);
           rs=pst.executeQuery();
           while (rs.next()){
               Libro libro = new Libro();
               libro.setIdLibro(rs.getInt("idLibro"));
               libro.setTitulo(rs.getString("tituloLibro"));
               libro.setAutor(rs.getString("autorLibro"));
               libro.setIdCategoria(rs.getInt("idCategoria"));
               list_Libro.add(libro);
           }
       }
       catch (Exception e)
       {
               JOptionPane.showMessageDialog(null,e.toString());
       }
        return list_Libro;       
       }
}
