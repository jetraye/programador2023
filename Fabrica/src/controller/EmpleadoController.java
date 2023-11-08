
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Empleado;
import model.EmpleadoDao;
import views.PantallaEmpleado;


public class EmpleadoController implements KeyListener, ActionListener, MouseListener  {
    
    private Empleado empleado;
    private EmpleadoDao empleadoDao;
    private PantallaEmpleado panta1;
    
    DefaultTableModel model=new DefaultTableModel();

    public EmpleadoController(Empleado empleado, EmpleadoDao empleadoDao, PantallaEmpleado panta1) {
        this.empleado = empleado;
        this.empleadoDao = empleadoDao;
        this.panta1 = panta1;
        
                        //boton agregar marca
        this.panta1.btn_Agregar.addActionListener(this);

        //boton modificar marca
        this.panta1.btn_Modificar.addActionListener(this);
        
        //boton borrar marca
        this.panta1.btn_Borrar.addActionListener(this);
        
        //boton limpiar
        this.panta1.btn_Limpiar.addActionListener(this);
        
        //listado de marca
        this.panta1.tb_Empleado.addMouseListener(this);
        listarEmpleado();
    }
    

    
    

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actionPerformed(ActionEvent e) {
if(e.getSource()==panta1.btn_Agregar){
    if (panta1.txt_Nombre.getText().equalsIgnoreCase("")){
        JOptionPane.showMessageDialog(null,"El campo nombre es obligatorio");

    }else{
        empleado.setApellido(panta1.txt_Apellido.getText());
        empleado.setNombre(panta1.txt_Nombre.getText());
        empleado.setDni(Integer.parseInt(panta1.txt_DNI.getText()));
        empleado.setSeccion(Integer.parseInt(panta1.txt_Seccion.getText()));

        if(empleadoDao.agregarEmpleado(empleado)){
            limpiarTabla();
            limpiarCampos();
            listarEmpleado();
            JOptionPane.showMessageDialog(null,"Se agrego el producto");
        }else{
            JOptionPane.showMessageDialog(null,"Ocurrio un error al agregar el producto");
        }
    }
}else if(e.getSource()==panta1.btn_Modificar){
    if(panta1.txt_Id.getText().equals("")){
        JOptionPane.showMessageDialog(null,"Seleccione un registro");
    }else{
        empleado.setId_Empleado(Integer.parseInt(panta1.txt_Id.getText()));
        empleado.setApellido(panta1.txt_Apellido.getText());
        empleado.setNombre(panta1.txt_Nombre.getText());
        empleado.setDni(Integer.parseInt(panta1.txt_DNI.getText()));
        empleado.setSeccion(Integer.parseInt(panta1.txt_Seccion.getText()));
        
        if(empleadoDao.modificarEmpleado(empleado)){
            limpiarTabla();
            limpiarCampos();
            listarEmpleado();
            panta1.btn_Agregar.setEnabled(true);
            JOptionPane.showMessageDialog(null,"El producto se modifico con exito");
            }else
        {
                 JOptionPane.showMessageDialog(null,"Ocurrio un error al modificar el producto");   
        }
    }
}else if (e.getSource()==panta1.btn_Borrar)
{
    if(panta1.txt_Id.getText().equals(""))
    {
        JOptionPane.showMessageDialog(null,"Seleccione un registro");
    }else
    {
        int id=Integer.parseInt(panta1.txt_Id.getText());
        if(empleadoDao.borrarEmpleado(id))
            {
            limpiarTabla();
            limpiarCampos();
            listarEmpleado();
            panta1.btn_Agregar.setEnabled(true);
            JOptionPane.showMessageDialog(null,"El producto se elimino con exito");
            }else{
            JOptionPane.showMessageDialog(null,"Hubo un error al eliminar el producto");
        }
    }
} else if(e.getSource()==panta1.btn_Limpiar)
        {
            limpiarTabla();
            limpiarCampos();
            listarEmpleado();
            panta1.btn_Agregar.setEnabled(true);
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

     if (e.getSource()== panta1.tb_Empleado)
                {
            int row = panta1.tb_Empleado.rowAtPoint(e.getPoint());
            panta1.txt_Id.setText(panta1.tb_Empleado.getValueAt(row,0).toString());
            panta1.txt_Apellido.setText(panta1.tb_Empleado.getValueAt(row,1).toString());
            panta1.txt_Nombre.setText(panta1.tb_Empleado.getValueAt(row,2).toString());
            panta1.txt_DNI.setText(panta1.tb_Empleado.getValueAt(row, 3).toString());
            panta1.txt_Seccion.setText(panta1.tb_Empleado.getValueAt(row,4).toString());
            panta1.btn_Agregar.setEnabled(false);
                }    
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    
           public void listarEmpleado(){
        List <Empleado> list =empleadoDao.listarEmpleado();
        model=(DefaultTableModel) panta1.tb_Empleado.getModel();
        Object[] row=new Object[5];
        limpiarTabla(); 
        for (int i=0;i<list.size();i++)
        {
            row[0] = list.get(i).getId_Empleado();
            row[1] = list.get(i).getApellido();
            row[2] = list.get(i).getNombre();
            row[3] = list.get(i).getDni();
            row[4] = list.get(i).getSeccion();
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
        panta1.txt_Apellido.setText("");
        panta1.txt_DNI.setText("");
        panta1.txt_Id.setText("");
        panta1.txt_Nombre.setText("");
        panta1.txt_Seccion.setText("");
    }
}

