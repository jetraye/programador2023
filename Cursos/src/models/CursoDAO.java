
package models;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import view.Vista;

public class CursoDAO {
    
    Curso curso = new Curso();
            
    public void agregarCurso(JTextField nombre_curso, JTextField fecha_inicio_curso,JTextField fecha_fin_curso, JTextField dias_curso, JTextField horario_curso){
    curso.setNombre_curso(nombre_curso.getText());
    curso.setFecha_inicio_curso(fecha_inicio_curso.getText());
    curso.setFecha_fin_curso(fecha_fin_curso.getText());
    curso.setDias_curso(dias_curso.getText());
    curso.setHorario_curso(horario_curso.getText());
    Conexion con = new Conexion();
    
    String comando ="INSERT INTO curso(nombre_curso,fecha_inicio_curso,fecha_fin_curso,dias_curso,horario_curso) VALUES (?,?,?,?,?);";
    
    try {
    CallableStatement cs = con.conectar().prepareCall(comando);
    cs.setString(1, curso.getNombre_curso());
    cs.setString(2, curso.getFecha_inicio_curso());
    cs.setString(3, curso.getFecha_fin_curso());
    cs.setString(4, curso.getDias_curso());
    cs.setString(5, curso.getHorario_curso());
    cs.execute();
    JOptionPane.showMessageDialog(null, "Se agregó correctamente el Curso");
        } 
    catch (Exception e) {
    JOptionPane.showMessageDialog(null, "No se agregó correctamente el Curso, error: " +
    e.toString());
                        }
 }

    public void mostrarCurso(JTable totalCurso){
 Conexion con = new Conexion();
 DefaultTableModel tabla = new DefaultTableModel();
 tabla.addColumn("IdCurso");
 tabla.addColumn("Nombre del curso");
 tabla.addColumn("Fecha inicio");
 tabla.addColumn("Fecha fin");
 tabla.addColumn("Dias de curso");
 tabla.addColumn("Horario de curso");
 totalCurso.setModel(tabla);
 String sql = "SELECT * FROM curso;";
 String[] datos = new String[6];
 Statement st;
 try {
 st = con.conectar().createStatement();
 ResultSet rs = st.executeQuery(sql);
 while(rs.next()){
 datos[0] = rs.getString(1);
 datos[1] = rs.getString(2);
 datos[2] = rs.getString(3);
 datos[3] = rs.getString(4);
 datos[4] = rs.getString(5);
  datos[5] = rs.getString(6);

 tabla.addRow(datos); 
                 }
 totalCurso.setModel(tabla);
     } 
 catch (Exception e) {
 JOptionPane.showMessageDialog(null, "No se pudo mostrar los registros, error: " + e.toString());
                      }
 } 
        
    public void seleccionarCurso(JTable totalCurso, JTextField id_curso, JTextField nombre_curso, JTextField fecha_inicio_curso,
    JTextField fecha_fin_curso, JTextField dias_curso, JTextField horario_curso)
    {
 try {
 int fila = totalCurso.getSelectedRow();
 if (fila >= 0)  
 {
 id_curso.setText(totalCurso.getValueAt(fila, 0).toString());
 nombre_curso.setText(totalCurso.getValueAt(fila, 1).toString());
 fecha_inicio_curso.setText(totalCurso.getValueAt(fila, 2).toString());
 fecha_fin_curso.setText(totalCurso.getValueAt(fila, 3).toString());
 dias_curso.setText(totalCurso.getValueAt(fila, 4).toString());
 horario_curso.setText(totalCurso.getValueAt(fila, 5).toString());
 }
 else
 {
 JOptionPane.showMessageDialog(null, "Fila no seleccionada");
 }
 }
 catch (Exception e) 
 {
 JOptionPane.showMessageDialog(null, "Error de selección, error: " + e.toString());
 }
 } 
    
    public void modificarCurso(JTextField id_curso, JTextField nombre_curso, JTextField fecha_inicio_curso,
    JTextField fecha_fin_curso, JTextField dias_curso, JTextField horario_curso){
        curso.setId_curso(Integer.parseInt(id_curso.getText()));
        curso.setNombre_curso(nombre_curso.getText());
        curso.setFecha_fin_curso(fecha_fin_curso.getText());
        curso.setFecha_inicio_curso(fecha_inicio_curso.getText());
        curso.setDias_curso(dias_curso.getText());
        curso.setHorario_curso(horario_curso.getText());
        Conexion con = new Conexion();
        
        String comando ="UPDATE curso SET id_curso=?,nombre_curso=?,fecha_inicio_curso=?,fecha_fin_curso=?,dias_curso=?,horario_curso=? WHERE id_curso=?;";
        try {
             CallableStatement cs = con.conectar().prepareCall(comando);
             cs.setInt(1, curso.getId_curso());
             cs.setString(2, curso.getNombre_curso());
             cs.setString(3, curso.getFecha_inicio_curso());
             cs.setString(4, curso.getFecha_fin_curso());
             cs.setString(5, curso.getDias_curso());
             cs.setString(6, curso.getHorario_curso());
             cs.execute();
                JOptionPane.showMessageDialog(null, "Se modificó correctamente el Curso");
        } catch (Exception e) {
 JOptionPane.showMessageDialog(null, "No se modificó el Curso, error: " + e.toString());
        }
        
    }

    
    public void eliminarCurso(JTextField id_curso){
 curso.setId_curso(Integer.parseInt(id_curso.getText()));
 Conexion con = new Conexion();
 String comando ="DELETE FROM Curso WHERE id_curso=?;";
 try {
 CallableStatement cs = con.conectar().prepareCall(comando);
 cs.setInt(1, curso.getId_curso());
 cs.execute();
 JOptionPane.showMessageDialog(null, "Se eliminó correctamente el curso");
 } catch (Exception e) {
 JOptionPane.showMessageDialog(null, "No se eliminó el curso, error: " + e.toString());
 }
 } 

}
