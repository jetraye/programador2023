
package Models;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class ProductoDao {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    public ProductoDao() {
    }
    
        public boolean agregarProducto(Producto producto){
        String query = "INSERT INTO producto(nombre_Producto,detalle_Producto,fecha_Compra_Producto,precio_Compra_Producto,precio_Venta_Producto,stock_Producto) VALUES (?,?,?,?,?,?)";
        try {
            con = cn.conectar();
            pst=con.prepareStatement(query);
            pst.setString(1,producto.getNombre()); 
            pst.setString(2,producto.getDetalle());
            pst.setString(3,producto.getFechaCompra());
            pst.setDouble(4,producto.getPrecioCompra());
            pst.setDouble(5,producto.getPrecioVenta());
            pst.setInt(6,producto.getStock());
            pst.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar el Producto"+e);
            return false;
        }
    }
            public boolean modificarProducto(Producto producto){
        String query = "UPDATE producto SET nombre_Producto=?,detalle_Producto=?,fecha_Compra_Producto=?,precio_Compra_Producto=?,precio_Venta_Producto=?,stock_Producto=? WHERE id_Producto = ?";
        try {
            con = cn.conectar();
            pst = con.prepareStatement(query);
            pst.setString(1,producto.getNombre());
            pst.setString(2,producto.getDetalle());
            pst.setString(3,producto.getFechaCompra());
            pst.setDouble(4,producto.getPrecioCompra());
            pst.setDouble(5,producto.getPrecioVenta());
            pst.setInt(6,producto.getStock());
            pst.setInt(7,producto.getId());
            pst.execute();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al modificar el producto"+e);
            return false;            
        }
    }   
               public boolean borrarProducto(int id){
       String query= "DELETE FROM producto WHERE id_Producto = " +id;
       try {
            con = cn.conectar();
            pst = con.prepareStatement(query);
            pst.execute();
            return true;          
       } 
       catch (Exception e)
       {
            JOptionPane.showMessageDialog(null, "No se puede eliminar un producto que tenga relacion a otra tabla"+e);
            return false;        
       }
       }
                  public List listarProducto (){
       List <Producto> list_producto = new ArrayList();
       String query = "SELECT * FROM producto ORDER BY nombre_Producto ASC ";
       try {
           con = cn.conectar();
           pst = con.prepareStatement(query);
           rs=pst.executeQuery();
           while (rs.next()){
               Producto producto = new Producto();
               producto.setId(rs.getInt("id_Producto"));
               producto.setNombre(rs.getString("nombre_Producto"));
               producto.setDetalle(rs.getString("detalle_Producto"));
               producto.setFechaCompra(rs.getString("fecha_Compra_Producto"));
               producto.setPrecioCompra(rs.getDouble("precio_Compra_Producto"));
               producto.setPrecioVenta(rs.getDouble("precio_Venta_Producto"));
               producto.setStock(rs.getInt("stock_Producto"));
               list_producto.add(producto);
           }
       }
       catch (Exception e)
       {
               JOptionPane.showMessageDialog(null,e.toString());
       }
        return list_producto;       
       }
   
}
