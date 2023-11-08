
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
import models.Libro;
import models.LibroDao;
import views.Pantalla;


public class LibroController implements KeyListener, ActionListener, MouseListener {
    
    private Libro libro;
    private LibroDao libroDao;
    private Pantalla panta1;
    
    DefaultTableModel model=new DefaultTableModel();

    public LibroController(Libro libro, LibroDao libroDao, Pantalla panta1) {
        this.libro = libro;
        this.libroDao = libroDao;
        this.panta1 = panta1;
        
        this.panta1.btn_Libro_Agregar.addActionListener(this);

        //boton modificar marca
        this.panta1.btn_Libro_Modificar.addActionListener(this);
        
        //boton borrar marca
        this.panta1.btn_Libro_Borrar.addActionListener(this);
        
        //boton limpiar
        this.panta1.btn_Libro_Limpiar.addActionListener(this);
        
        //listado de marca
        this.panta1.tb_Libros.addMouseListener(this);
        
        listarLibro();
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
if(e.getSource()==panta1.btn_Libro_Agregar){
    if (panta1.txt_TituloLibro.getText().equalsIgnoreCase("")){
        JOptionPane.showMessageDialog(null,"El campo titulo es obligatorio");

    }else{
        libro.setTitulo(panta1.txt_TituloLibro.getText());
        libro.setAutor(panta1.txt_AutorLibro.getText());
        libro.setIdCategoria(Integer.parseInt(panta1.txt_Categoria_Libro.getText()));

        if(libroDao.agregarLibro(libro)){
            limpiarTabla();
            limpiarCampos();
            listarLibro();
            JOptionPane.showMessageDialog(null,"Se agrego el libro");
        }else{
            JOptionPane.showMessageDialog(null,"Ocurrio un error al agregar el libro");
        }
    }
}else if(e.getSource()==panta1.btn_Libro_Modificar){
    if(panta1.txt_IdLibro.getText().equals("")){
        JOptionPane.showMessageDialog(null,"Seleccione un registro");
    }else{
        libro.setIdLibro(Integer.parseInt(panta1.txt_IdLibro.getText()));
        libro.setTitulo(panta1.txt_TituloLibro.getText());
        libro.setAutor(panta1.txt_AutorLibro.getText());
        libro.setIdCategoria(Integer.parseInt(panta1.txt_Categoria_Libro.getText()));
        
        if(libroDao.modificarLibro(libro)){
            limpiarTabla();
            limpiarCampos();
            listarLibro();
            panta1.btn_Libro_Agregar.setEnabled(true);
            JOptionPane.showMessageDialog(null,"El libro se modifico con exito");
            }else
        {
                 JOptionPane.showMessageDialog(null,"Ocurrio un error al modificar el libro");   
        }
    }
}else if (e.getSource()==panta1.btn_Libro_Borrar)
{
    if(panta1.txt_IdLibro.getText().equals(""))
    {
        JOptionPane.showMessageDialog(null,"Seleccione un registro");
    }else
    {
        int id=Integer.parseInt(panta1.txt_IdLibro.getText());
        if(libroDao.borrarLibro(id))
            {
            limpiarTabla();
            limpiarCampos();
            listarLibro();
            panta1.btn_Libro_Agregar.setEnabled(true);
            JOptionPane.showMessageDialog(null,"El libro se elimino con exito");
            }else{
            JOptionPane.showMessageDialog(null,"Hubo un error al eliminar el libro");
        }
    }
} else if(e.getSource()==panta1.btn_Libro_Limpiar)
        {
            limpiarTabla();
            limpiarCampos();
            listarLibro();
            panta1.btn_Libro_Agregar.setEnabled(true);
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

     if (e.getSource()== panta1.tb_Libros)
                {
            int row = panta1.tb_Libros.rowAtPoint(e.getPoint());
            panta1.txt_IdLibro.setText(panta1.tb_Libros.getValueAt(row,0).toString());
            panta1.txt_TituloLibro.setText(panta1.tb_Libros.getValueAt(row,1).toString());
            panta1.txt_AutorLibro.setText(panta1.tb_Libros.getValueAt(row,2).toString());
            panta1.txt_Categoria_Libro.setText(panta1.tb_Libros.getValueAt(row, 3).toString());
            panta1.btn_Libro_Agregar.setEnabled(false);
                }    
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    
    
    
    
    
              public void listarLibro(){
        List <Libro> list =libroDao.listarLibro();
        model=(DefaultTableModel) panta1.tb_Libros.getModel();
        Object[] row=new Object[4];
        limpiarTabla(); 
        for (int i=0;i<list.size();i++)
        {
            row[0] = list.get(i).getIdLibro();
            row[1] = list.get(i).getTitulo();
            row[2] = list.get(i).getAutor();
            row[3] = list.get(i).getIdCategoria();
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
        panta1.txt_AutorLibro.setText("");
        panta1.txt_Categoria_Libro.setText("");
        panta1.txt_IdLibro.setText("");
        panta1.txt_TituloLibro.setText("");
    }
    
}
