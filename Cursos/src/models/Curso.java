
package models;

import java.sql.CallableStatement;
import javax.swing.JOptionPane;
import javax.swing.JTextField; 
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.Statement;
import java.sql.ResultSet; 

public class Curso {
    private int id_curso;
    private String nombre_curso;
    private String fecha_inicio_curso;
    private String fecha_fin_curso;
    private String dias_curso;
    private String horario_curso;

    public Curso() {
    }

    public Curso(int id_curso, String nombre_curso, String fecha_inicio_curso, String fecha_fin_curso, String dias_curso, String horario_curso) {
        this.id_curso = id_curso;
        this.nombre_curso = nombre_curso;
        this.fecha_inicio_curso = fecha_inicio_curso;
        this.fecha_fin_curso = fecha_fin_curso;
        this.dias_curso = dias_curso;
        this.horario_curso = horario_curso;
    }
    
    
    public int getId_curso() {
        return id_curso;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }

    public String getNombre_curso() {
        return nombre_curso;
    }

    public void setNombre_curso(String nombre_curso) {
        this.nombre_curso = nombre_curso;
    }

    public String getFecha_inicio_curso() {
        return fecha_inicio_curso;
    }

    public void setFecha_inicio_curso(String fecha_inicio_curso) {
        this.fecha_inicio_curso = fecha_inicio_curso;
    }

    public String getFecha_fin_curso() {
        return fecha_fin_curso;
    }

    public void setFecha_fin_curso(String fecha_fin_curso) {
        this.fecha_fin_curso = fecha_fin_curso;
    }

    public String getDias_curso() {
        return dias_curso;
    }

    public void setDias_curso(String dias_curso) {
        this.dias_curso = dias_curso;
    }

    public String getHorario_curso() {
        return horario_curso;
    }

    public void setHorario_curso(String horario_curso) {
        this.horario_curso = horario_curso;
    }

    
    
    
}
