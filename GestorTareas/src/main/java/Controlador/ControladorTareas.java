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
    public static int contador;
    
    private Tarea modelo;
    private FormularioPrincipal vista;
    private Conexion conectar = new Conexion();

    
    public ControladorTareas(Tarea modelo, FormularioPrincipal vista) {
        this.modelo = modelo;
        this.vista = vista;
                
        //Aqui va toda la logica de la controladora
        contador = contarRegistros();
        mostrarDatos();
        
        
        //Para agregar datos cuando se presiona el boton agregar:
        
        this.vista.btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarDatos();
            }
        });
        
        this.vista.btnCompletar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                marcarCompletado();
            }
        });
        
        this.vista.btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarTarea();
            }
        });
        
        
    }// Fin de ControladorTareas
        
    public int generarID(){
        contador++;
        return contador;
    }
    
    
    public int contarRegistros(){
        int count = 0;
        String sql = "SELECT COUNT(*) FROM lista_tareas";

        try (
            PreparedStatement pstmt = conectar.Conectar().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery()) {

            if (rs.next()) {
                count = rs.getInt(1);
            }

        } 
        catch (SQLException e) {
            e.printStackTrace();
        }

        return count;
    }
    
    
    public void agregarDatos(){
        

        modelo = new Tarea(generarID());
        
        //Debe estar seleccionada una linea para agregarla
        int rec = vista.TablaTareasPrincipales.getSelectedRow();
        if (rec == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila primero.");
            return;
        }
        
        
        //Se extraen los datos de la fila seleccionada:
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
           String sql = "INSERT INTO lista_tareas (id,tarea,fecha,responsable,estado,descripcion) VALUES (?,?,?,?,?,?)";
    
           PreparedStatement pstmt = conectar.Conectar().prepareStatement(sql); 
            pstmt.setInt(1, modelo.getId());
            pstmt.setString(2, modelo.getTarea());
            
            //Para insertar la fecha:
            String fechaStr = vista.TablaTareasPrincipales.getValueAt(rec, 2).toString();
            java.sql.Date fechaSQL = java.sql.Date.valueOf(fechaStr);
            pstmt.setDate(3, fechaSQL);
            
            
            pstmt.setString(4, modelo.getResponsable());
            pstmt.setString(5,modelo.getEstado());
            pstmt.setString(6,modelo.getDescripcion());
            pstmt.executeUpdate();
            
       } 
       catch (SQLException e) 
        {
            e.printStackTrace();
        }
       
       mostrarDatos();


    

    }// fn del metodo agregar datos 
    
        public void marcarCompletado(){
        

        modelo = new Tarea(generarID());
        
        //Debe estar seleccionada una linea para agregarla
        int rec = vista.TablaTareasPrincipales.getSelectedRow();
        if (rec == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila primero.");
            return;
        }
        
        
        //Se extrae el ID
        int idSeleccionado = Integer.parseInt(vista.TablaTareasPrincipales.getValueAt(rec, 0).toString());
        modelo.setId(idSeleccionado);
             
       
       try {
           String sql = "UPDATE lista_tareas set estado='Completado' where id=?";
    
            PreparedStatement pstmt = conectar.Conectar().prepareStatement(sql); 
            pstmt.setInt(1, modelo.getId());
            
            pstmt.executeUpdate();
            
       } 
       catch (SQLException e) 
        {
            e.printStackTrace();
        }
       
       mostrarDatos();


    

    }// fn del metodo marcarCompletado()
        
        public void eliminarTarea(){
        

        modelo = new Tarea(generarID());
        
        //Debe estar seleccionada una linea para agregarla
        int rec = vista.TablaTareasPrincipales.getSelectedRow();
        if (rec == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila primero.");
            return;
        }
        
        
        //Se extrae el ID y tarea
        int idSeleccionado = Integer.parseInt(vista.TablaTareasPrincipales.getValueAt(rec, 0).toString());
        modelo.setId(idSeleccionado);
        
        String tareaSeleccionada = vista.TablaTareasPrincipales.getValueAt(rec, 1).toString();
        modelo.setTarea(tareaSeleccionada);
        
        
        //Se confirma si realmente desea eliminar tarea
        
        int opcion = JOptionPane.showConfirmDialog(
            vista,
            "Realmente desea eliminar la tarea '" + tareaSeleccionada + "'?",
            "Confirmar eliminación",
            JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.WARNING_MESSAGE
        );
        
        if (opcion == JOptionPane.CANCEL_OPTION) {
            //Si se elije que no, entonces se termina la función
            return;
        } 
        
       //Si usuario desea continuar se elimina por celda seleccionada
        
       try {
           String sql = "DELETE from lista_tareas where id=?";
    
            PreparedStatement pstmt = conectar.Conectar().prepareStatement(sql); 
            pstmt.setInt(1, modelo.getId());
            
            pstmt.executeUpdate();
            
       } 
       catch (SQLException e) 
        {
            e.printStackTrace();
        }
       
       mostrarDatos();


    

    }// fn del metodo eliminarTarea()
    
    public void mostrarDatos(){
        
        DefaultTableModel tabla = new DefaultTableModel();// crea una tabla por defecto
        int indice;// El indice para recorrer la tabla de la base de datos
        
        // Se crean las columna de la tabla
        tabla.addColumn("ID");
        tabla.addColumn("Tarea");
        tabla.addColumn("Fecha");
        tabla.addColumn("Responsable");
        tabla.addColumn("Estado");
        tabla.addColumn("Descripcion");
        tabla.setRowCount(contarRegistros()+1);
        
        try
        {
            PreparedStatement da = conectar.Conectar().prepareStatement("select * from lista_tareas"); 
            ResultSet tbl = da.executeQuery();
            
            
            indice=0; 
            while(tbl.next())
            { 
         
            tabla.setValueAt(tbl.getString("id"),indice,0); 
            tabla.setValueAt(tbl.getString("Tarea"),indice,1); 
            tabla.setValueAt(tbl.getString("Fecha"),indice,2);
            tabla.setValueAt(tbl.getString("Responsable"),indice,3);
            tabla.setValueAt(tbl.getString("Estado"),indice,4);
            tabla.setValueAt(tbl.getString("Descripcion"),indice,5);
            
         
            indice++; 
            }
        }
            catch(SQLException e)
            {
                    
                e.printStackTrace();
            }
    
        vista.TablaTareasPrincipales.setModel(tabla);
        
    }
       
    
    
}
