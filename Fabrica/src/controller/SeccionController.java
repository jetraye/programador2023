
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
import model.Seccion;
import model.SeccionDao;
import views.PantallaSeccion;

public class SeccionController  implements KeyListener, ActionListener, MouseListener{

    private Seccion seccion;
    private SeccionDao seccionDao;
    private PantallaSeccion panta2;
    
    DefaultTableModel model=new DefaultTableModel();

    public SeccionController(Seccion seccion, SeccionDao seccionDao, PantallaSeccion panta2) {
        this.seccion = seccion;
        this.seccionDao = seccionDao;
        this.panta2 = panta2;
        
        this.panta2.btn_Agregar.addActionListener(this);

        //boton modificar marca
        this.panta2.btn_Modificar.addActionListener(this);
        
        //boton borrar marca
        this.panta2.btn_Borrar.addActionListener(this);
        
        //boton limpiar
        this.panta2.btn_Limpiar.addActionListener(this);
        
        //listado de marca
        this.panta2.tb_Seccion.addMouseListener(this);
        
        listarSeccion();
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
if(e.getSource()==panta2.btn_Agregar){
    if (panta2.txt_Seccion.getText().equalsIgnoreCase("")){
        JOptionPane.showMessageDialog(null,"El campo nombre es obligatorio");

    }else{
        seccion.setNombre(panta2.txt_Seccion.getText());

        if(seccionDao.agregarSeccion(seccion)){
            limpiarTabla();
            limpiarCampos();
            listarSeccion();
            JOptionPane.showMessageDialog(null,"Se agrego el producto");
        }else{
            JOptionPane.showMessageDialog(null,"Ocurrio un error al agregar el producto");
        }
    }
}else if(e.getSource()==panta2.btn_Modificar){
    if(panta2.txt_Id.getText().equals("")){
        JOptionPane.showMessageDialog(null,"Seleccione un registro");
    }else{
        seccion.setId_Seccion(Integer.parseInt(panta2.txt_Id.getText()));
        seccion.setNombre(panta2.txt_Seccion.getText());
        if(seccionDao.modificarSeccion(seccion)){
            limpiarTabla();
            limpiarCampos();
            listarSeccion();
            panta2.btn_Agregar.setEnabled(true);
            JOptionPane.showMessageDialog(null,"El producto se modifico con exito");
            }else
        {
                 JOptionPane.showMessageDialog(null,"Ocurrio un error al modificar el producto");   
        }
    }
}else if (e.getSource()==panta2.btn_Borrar)
{
    if(panta2.txt_Id.getText().equals(""))
    {
        JOptionPane.showMessageDialog(null,"Seleccione un registro");
    }else
    {
        int id=Integer.parseInt(panta2.txt_Id.getText());
        if(seccionDao.borrarSeccion(id))
            {
            limpiarTabla();
            limpiarCampos();
            listarSeccion();
            panta2.btn_Agregar.setEnabled(true);
            JOptionPane.showMessageDialog(null,"El producto se elimino con exito");
            }else{
            JOptionPane.showMessageDialog(null,"Hubo un error al eliminar el producto");
        }
    }
} else if(e.getSource()==panta2.btn_Limpiar)
        {
            limpiarTabla();
            limpiarCampos();
            listarSeccion();
            panta2.btn_Agregar.setEnabled(true);
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
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
           public void listarSeccion(){
        List <Seccion> list =seccionDao.listarSeccion();
        model=(DefaultTableModel) panta2.tb_Seccion.getModel();
        Object[] row=new Object[2];
        limpiarTabla(); 
        for (int i=0;i<list.size();i++)
        {
            row[0] = list.get(i).getId_Seccion();
            row[1] = list.get(i).getNombre();
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
        panta2.txt_Id.setText("");
        panta2.txt_Seccion.setText("");
    }    
}
