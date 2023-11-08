
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Categoria;
import models.CategoriaDao;
import models.Libro;
import views.Pantalla;


public class CategoriaController implements KeyListener, ActionListener, MouseListener{

    private Categoria categoria;
    private CategoriaDao categoriaDao;
    private Pantalla panta1;
    
    DefaultTableModel model=new DefaultTableModel();


    public CategoriaController(Categoria categoria, CategoriaDao categoriaDao, Pantalla panta1) {
        this.categoria = categoria;
        this.categoriaDao = categoriaDao;
        this.panta1 = panta1;
        
        
        this.panta1.btn_Categoria_Agregar.addActionListener(this);

        //boton modificar marca
        this.panta1.btn_Categoria_Modificar.addActionListener(this);
        
        //boton borrar marca
        this.panta1.btn_Categoria_Borrar.addActionListener(this);
        
        //boton limpiar
        this.panta1.btn_Categoria_Limpiar.addActionListener(this);
        
        //listado de marca
        this.panta1.tb_Categoria.addMouseListener(this);
        
        
        listarCategoria();
        
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
if(e.getSource()==panta1.btn_Categoria_Agregar){
    if (panta1.txt_NombreCategoria.getText().equalsIgnoreCase("")){
        JOptionPane.showMessageDialog(null,"El campo nombre es obligatorio");

    }else{
        categoria.setNombreCategoria(panta1.txt_NombreCategoria.getText());

        if(categoriaDao.agregarCategoria(categoria)){
            limpiarTabla();
            limpiarCampos();
            listarCategoria();
            JOptionPane.showMessageDialog(null,"Se agrego la categoria");
        }else{
            JOptionPane.showMessageDialog(null,"Ocurrio un error al agregar la categoria");
        }
    }
}else if(e.getSource()==panta1.btn_Categoria_Modificar){
    if(panta1.txt_IdCategoria.getText().equals("")){
        JOptionPane.showMessageDialog(null,"Seleccione un registro");
    }else{
        categoria.setIdCategoria(Integer.parseInt(panta1.txt_IdCategoria.getText()));
        categoria.setNombreCategoria(panta1.txt_NombreCategoria.getText());
        
        if(categoriaDao.modificarCategoria(categoria)){
            limpiarTabla();
            limpiarCampos();
            listarCategoria();
            panta1.btn_Categoria_Agregar.setEnabled(true);
            JOptionPane.showMessageDialog(null,"El libro se modifico con exito");
            }else
        {
                 JOptionPane.showMessageDialog(null,"Ocurrio un error al modificar el libro");   
        }
    }
}else if (e.getSource()==panta1.btn_Categoria_Borrar)
{
    if(panta1.txt_IdCategoria.getText().equals(""))
    {
        JOptionPane.showMessageDialog(null,"Seleccione un registro");
    }else
    {
        int id=Integer.parseInt(panta1.txt_IdCategoria.getText());
        if(categoriaDao.borrarCategoria(id))
            {
            limpiarTabla();
            limpiarCampos();
            listarCategoria();
            panta1.btn_Categoria_Agregar.setEnabled(true);
            JOptionPane.showMessageDialog(null,"El libro se elimino con exito");
            }else{
            JOptionPane.showMessageDialog(null,"Hubo un error al eliminar el libro");
        }
    }
} else if(e.getSource()==panta1.btn_Categoria_Limpiar)
        {
            limpiarTabla();
            limpiarCampos();
            listarCategoria();
            panta1.btn_Categoria_Agregar.setEnabled(true);
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
             if (e.getSource()== panta1.tb_Categoria)
                {
            int row = panta1.tb_Categoria.rowAtPoint(e.getPoint());
            panta1.txt_IdCategoria.setText(panta1.tb_Categoria.getValueAt(row,0).toString());
            panta1.txt_NombreCategoria.setText(panta1.tb_Categoria.getValueAt(row,1).toString());
            panta1.btn_Categoria_Agregar.setEnabled(false);
                }    
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    
    
                 public void listarCategoria(){
        List <Categoria> list =categoriaDao.listarCategoria();
        model=(DefaultTableModel) panta1.tb_Categoria.getModel();
        Object[] row=new Object[1];
        limpiarTabla(); 
        for (int i=0;i<list.size();i++)
        {
            row[0] = list.get(i).getIdCategoria();
            row[1] = list.get(i).getNombreCategoria();
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
        panta1.txt_NombreCategoria.setText("");
        panta1.txt_IdCategoria.setText("");
    }
}
