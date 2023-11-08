
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.table.DefaultTableModel;
import models.Curso;
import models.CursoDAO;
import view.Vista;


public class CursoControlador implements ActionListener,  MouseListener, KeyListener{
    
    
    private Curso curso;
    private CursoDAO cursoDAO;
    private Vista vista;
    
    DefaultTableModel model = new DefaultTableModel();
                       

    public CursoControlador (Curso curso, CursoDAO cursoDAO, Vista vista){
        this.curso =curso;
        this.cursoDAO = cursoDAO;
        this.vista = vista;
        
        this.vista.btn_Agregar.addActionListener(this);
        this.vista.btn_Modificar.addActionListener(this);
        this.vista.btn_Borrar.addActionListener(this);
        this.vista.btn_Limpiar.addActionListener(this);
        this.vista.tbCurso.addMouseListener(this);
    }
            
    
    

    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==vista.btn_Agregar)
        {
            cursoDAO.agregarCurso(vista.txt_Nombre, vista.txt_Inicio, vista.txt_Fin, vista.txt_Dias, vista.txt_Horario);
            vista.limpiarCampos();
            cursoDAO.mostrarCurso(vista.tbCurso);
        }
        else if(e.getSource()==vista.btn_Modificar)
        {
            cursoDAO.modificarCurso( vista.txt_Id,  vista.txt_Nombre,  vista.txt_Inicio, vista.txt_Fin,  vista.txt_Dias, vista.txt_Horario);
            limpiarCampos(); 
            cursoDAO.mostrarCurso( vista.tbCurso);
        }
        else if(e.getSource()==vista.btn_Borrar)
        {
        cursoDAO.eliminarCurso(vista.txt_Id);
        limpiarCampos();
        cursoDAO.mostrarCurso(vista.tbCurso);
        }
        else if(e.getSource()==vista.btn_Limpiar)
        {
        limpiarCampos();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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


public void limpiarCampos(){
vista.txt_Id.setText("");
vista.txt_Nombre.setText("");
vista.txt_Inicio.setText("");
vista.txt_Fin.setText("");
vista.txt_Horario.setText("");
vista.txt_Dias.setText("");

}

}
