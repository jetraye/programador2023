
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
import models.Paciente;
import models.PacienteDao;
import views.Pantalla;


public class PacienteController implements KeyListener, ActionListener, MouseListener {
    private Paciente paciente;
    private PacienteDao pacienteDao;
    private Pantalla panta1;
    
        DefaultTableModel model=new DefaultTableModel();

    public PacienteController(Paciente paciente, PacienteDao pacienteDao, Pantalla panta1) {
        this.paciente = paciente;
        this.pacienteDao = pacienteDao;
        this.panta1 = panta1;
                
        this.panta1.btnAgregar.addActionListener(this);
        this.panta1.btnModificar.addActionListener(this);
        this.panta1.btnBorrar.addActionListener(this);
        this.panta1.btnLimpiar.addActionListener(this);
        this.panta1.tbPacientes.addMouseListener(this);
        
        listarPacientes();
        
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
if(e.getSource()==panta1.btnAgregar){
    if (panta1.txtApellidos.getText().equalsIgnoreCase("")){
        JOptionPane.showMessageDialog(null,"El campo Apellido es obligatorio");

    }else{
        paciente.setApellidos(panta1.txtApellidos.getText());
        paciente.setNombres(panta1.txtNombres.getText());
        paciente.setEdad(Integer.parseInt(panta1.txtEdad.getText()));
        paciente.setDni(Integer.parseInt(panta1.txtDni.getText()));
        paciente.setCelular(panta1.txtCelular.getText());

        if(pacienteDao.agregarPaciente(paciente)){
            limpiarTabla();
            limpiarCampos();
            listarPacientes();
            JOptionPane.showMessageDialog(null,"Se agrego el paciente");
        }else{
            JOptionPane.showMessageDialog(null,"Ocurrio un error al agregar el paciente");
        }
    }
}else if(e.getSource()==panta1.btnModificar){
    if(panta1.txtId.getText().equals("")){
        JOptionPane.showMessageDialog(null,"Seleccione un registro");
    }else{
        paciente.setIdPaciente(Integer.parseInt(panta1.txtId.getText()));
        paciente.setApellidos(panta1.txtApellidos.getText());
        paciente.setNombres(panta1.txtNombres.getText());
        paciente.setEdad(Integer.parseInt(panta1.txtEdad.getText()));
        paciente.setDni(Integer.parseInt(panta1.txtDni.getText()));
        paciente.setCelular(panta1.txtCelular.getText());
        
        if(pacienteDao.modificarPaciente(paciente)){
            limpiarTabla();
            limpiarCampos();
            listarPacientes();
            panta1.btnAgregar.setEnabled(true);
            JOptionPane.showMessageDialog(null,"El paciente se modifico con exito");
            }else
        {
                 JOptionPane.showMessageDialog(null,"Ocurrio un error al modificar el paciente");   
        }
    }
}else if (e.getSource()==panta1.btnBorrar)
{
    if(panta1.txtId.getText().equals(""))
    {
        JOptionPane.showMessageDialog(null,"Seleccione un registro");
    }else
    {
        int id=Integer.parseInt(panta1.txtId.getText());
        if(pacienteDao.borrarPaciente(id))
            {
            limpiarTabla();
            limpiarCampos();
            listarPacientes();
            panta1.btnAgregar.setEnabled(true);
            JOptionPane.showMessageDialog(null,"El paciente se elimino con exito");
            }else{
            JOptionPane.showMessageDialog(null,"Hubo un error al eliminar el paciente");
        }
    }
} else if(e.getSource()==panta1.btnLimpiar)
        {
            limpiarTabla();
            limpiarCampos();
            listarPacientes();
            panta1.btnAgregar.setEnabled(true);
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
             if (e.getSource()== panta1.tbPacientes)
                {
            int row = panta1.tbPacientes.rowAtPoint(e.getPoint());
            panta1.txtId.setText(panta1.tbPacientes.getValueAt(row,0).toString());
            panta1.txtApellidos.setText(panta1.tbPacientes.getValueAt(row,1).toString());
            panta1.txtNombres.setText(panta1.tbPacientes.getValueAt(row,2).toString());
            panta1.txtEdad.setText(panta1.tbPacientes.getValueAt(row, 3).toString());
            panta1.txtDni.setText(panta1.tbPacientes.getValueAt(row, 4).toString());
            panta1.txtCelular.setText(panta1.tbPacientes.getValueAt(row, 5).toString());
            panta1.btnAgregar.setEnabled(false);
                }    
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
   
              public void listarPacientes(){
        List <Paciente> list =pacienteDao.listarPacientes();
        model=(DefaultTableModel) panta1.tbPacientes.getModel();
        Object[] row=new Object[6];
        limpiarTabla(); 
        for (int i=0;i<list.size();i++)
        {
            row[0] = list.get(i).getIdPaciente();
            row[1] = list.get(i).getApellidos();
            row[2] = list.get(i).getNombres();
            row[3] = list.get(i).getEdad();
            row[4] = list.get(i).getDni();
            row[5] = list.get(i).getCelular();
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
        panta1.txtApellidos.setText("");
        panta1.txtNombres.setText("");
        panta1.txtEdad.setText("");
        panta1.txtDni.setText("");
        panta1.txtCelular.setText("");
        panta1.txtId.setText("");
    }
}
