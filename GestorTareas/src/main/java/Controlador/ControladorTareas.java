/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Datos.Conexion;
import Modelo.Tarea;
import Vista.FormularioPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import java.io.FileOutputStream;
import javax.swing.table.TableModel;


public class ControladorTareas {
    public static int contador = 0;
    
    private Tarea modelo;
    private FormularioPrincipal vista;
    private Conexion conectar = new Conexion();

    
    public ControladorTareas(Tarea modelo, FormularioPrincipal vista) {
        this.modelo = modelo;
        this.vista = vista;
        
        
        //Aqui va toda la logica de la controladora
        
        this.vista.btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarDatos();
                //mostrarDatos();
            }
        });
        
        
    }// Fin de ControladorTareas
        
    public int generarID(){
        contador++;
        return contador;
    }
    
    public void agregarDatos(){
        modelo= new Tarea(generarID());
        
        int rec = vista.TablaTareasPrincipales.getSelectedRow();
        String tareaSeleccionada = vista.TablaTareasPrincipales.getValueAt(rec, 1).toString();
        modelo.setTarea(tareaSeleccionada);
        
        String FechaSeleccionada = vista.TablaTareasPrincipales.getValueAt(rec, 2).toString();
        modelo.setFecha(FechaSeleccionada);
        
        
        String ResponsableSeleccionado = vista.TablaTareasPrincipales.getValueAt(rec, 3).toString();
        modelo.setResponsable(ResponsableSeleccionado);
        
        String EstadoSeleccionado = vista.TablaTareasPrincipales.getValueAt(rec, 4).toString();
        modelo.setEstado(EstadoSeleccionado);
        
        String DescripcionSeleccionada = vista.TablaTareasPrincipales.getValueAt(rec, 5).toString();
        modelo.setDescripcion(DescripcionSeleccionada);
        
    
         
       try {
           String sql = "INSERT INTO Persona VALUES (?,?,?,?,?)";
    
           PreparedStatement pstmt = conectar.Conectar().prepareStatement(sql); 
            pstmt.setInt(0, modelo.getId());
            pstmt.setString(1, modelo.getTarea());
            pstmt.setString(2, modelo.getFecha());
            pstmt.setString(3, modelo.getResponsable());
            pstmt.setString(4,modelo.getEstado());
            pstmt.setString(4,modelo.getDescripcion());
            pstmt.executeUpdate();
           
        
       } 
       catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }// fn del metodo agregar datos 
       
    
    
}
