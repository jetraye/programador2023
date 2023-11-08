
package Controllers;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import Models.Producto;
import Models.ProductoDao;
import Views.Pantalla;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;





public class ProductoControlador implements KeyListener, ActionListener, MouseListener {
    
private Producto producto;
private ProductoDao productoDao;
private Pantalla panta;

DefaultTableModel model=new DefaultTableModel();

    public ProductoControlador(Producto producto, ProductoDao productoDao, Pantalla panta) {
        this.producto = producto;
        this.productoDao = productoDao;
        this.panta = panta;
        //boton agregar producto
        this.panta.btnAgregar.addActionListener(this);

        //boton modificar producto
        this.panta.btnModificar.addActionListener(this);
        
        //boton borrar producto
        this.panta.btnBorrar.addActionListener(this);
        
        //boton limpiar
        this.panta.btnLimpiar.addActionListener(this);
        
        //listado de producto
        this.panta.tbProductoTabla.addMouseListener(this);
        
        
        listarProductos();

    }
        
 


 
    
    
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
      }    

    @Override
    public void actionPerformed(ActionEvent e) {
if(e.getSource()==panta.btnAgregar){
    if (panta.txtNombre.getText().equalsIgnoreCase("")){
        JOptionPane.showMessageDialog(null,"El campo nombre es obligatorio");

    }else{
        producto.setNombre(panta.txtNombre.getText());
        producto.setDetalle(panta.txtDetalle.getText());
        producto.setFechaCompra(panta.txtFechaCompra.getText());
        producto.setPrecioCompra(Double.parseDouble(panta.txtPrecioCompra.getText()));       
        producto.setPrecioVenta(Double.parseDouble(panta.txtPrecioVenta.getText()));
        producto.setStock(Integer.parseInt(panta.txtStock.getText()));

        if(productoDao.agregarProducto(producto)){
            limpiarTabla();
            limpiarCampos();
            listarProductos();
            JOptionPane.showMessageDialog(null,"Se agrego el producto");
        }else{
            JOptionPane.showMessageDialog(null,"Ocurrio un error al agregar el producto");
        }
    }
}else if(e.getSource()==panta.btnModificar){
    if(panta.txtId.getText().equals("")){
        JOptionPane.showMessageDialog(null,"Seleccione un registro");
    }else{
        producto.setId(Integer.parseInt(panta.txtId.getText()));
        producto.setNombre(panta.txtNombre.getText());
        producto.setDetalle(panta.txtDetalle.getText());
        producto.setFechaCompra(panta.txtFechaCompra.getText());
        producto.setPrecioCompra(Double.parseDouble(panta.txtPrecioCompra.getText()));       
        producto.setPrecioVenta(Double.parseDouble(panta.txtPrecioVenta.getText()));
        producto.setStock(Integer.parseInt(panta.txtStock.getText()));
        
        if(productoDao.modificarProducto(producto)){
            limpiarTabla();
            limpiarCampos();
            listarProductos();
            panta.btnAgregar.setEnabled(true);
            JOptionPane.showMessageDialog(null,"El producto se modifico con exito");
            }else
        {
                 JOptionPane.showMessageDialog(null,"Ocurrio un error al modificar el producto");   
        }
    }
}else if (e.getSource()==panta.btnBorrar)
{
    if(panta.txtId.getText().equals(""))
    {
        JOptionPane.showMessageDialog(null,"Seleccione un registro");
    }else
    {
        int id=Integer.parseInt(panta.txtId.getText());
        if(productoDao.borrarProducto(id))
            {
            limpiarTabla();
            limpiarCampos();
            listarProductos();
            panta.btnAgregar.setEnabled(true);
            JOptionPane.showMessageDialog(null,"El producto se elimino con exito");
            }else{
            JOptionPane.showMessageDialog(null,"Hubo un error al eliminar el producto");
        }
    }
} else if(e.getSource()==panta.btnLimpiar)
        {
            limpiarTabla();
            limpiarCampos();
            listarProductos();
            panta.btnAgregar.setEnabled(true);
        }
    }    

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
     if (e.getSource()== panta.tbProductoTabla)
                {
            int row = panta.tbProductoTabla.rowAtPoint(e.getPoint());
            panta.txtId.setText(panta.tbProductoTabla.getValueAt(row,0).toString());
            panta.txtNombre.setText(panta.tbProductoTabla.getValueAt(row,1).toString());
            panta.txtDetalle.setText(panta.tbProductoTabla.getValueAt(row, 2).toString());
            panta.txtFechaCompra.setText(panta.tbProductoTabla.getValueAt(row, 3).toString());
            panta.txtPrecioCompra.setText(panta.tbProductoTabla.getValueAt(row, 4).toString());
            panta.txtPrecioVenta.setText(panta.tbProductoTabla.getValueAt(row, 5).toString());
            panta.txtStock.setText(panta.tbProductoTabla.getValueAt(row, 6).toString());
            panta.btnAgregar.setEnabled(false);
                } 
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
           public void listarProductos(){
        List <Producto> list =productoDao.listarProducto();
        model=(DefaultTableModel) panta.tbProductoTabla.getModel();
        Object[] row=new Object[7];
        limpiarTabla(); 
        for (int i=0;i<list.size();i++)
        {
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getNombre();
            row[2] = list.get(i).getDetalle();
            row[3] = list.get(i).getFechaCompra();
            row[4] = list.get(i).getPrecioCompra();
            row[5] = list.get(i).getPrecioVenta();
            row[6] = list.get(i).getStock();
            model.addRow(row);
        }
    }
                   public void limpiarTabla()
    {
        for(int i=0;i<model.getRowCount();i++)
    {
        model.removeRow(i);
         i=i-1;
    
    }
    }
        public void limpiarCampos(){
            panta.txtId.setText("");
        panta.txtNombre.setText("");
        panta.txtDetalle.setText("");
        panta.txtFechaCompra.setText("");
        panta.txtPrecioCompra.setText("");
        panta.txtPrecioVenta.setText("");
        panta.txtStock.setText("");
    }
}
