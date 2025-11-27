/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Datos.Conexion;
import Modelo.Tarea;
import Vista.FormularioPrincipal;

public class ControladorTareas {
    
    private Tarea modelo;
    private FormularioPrincipal vista;
    private Conexion conectar = new Conexion();

    public ControladorTareas(Tarea modelo, FormularioPrincipal vista) {
        this.modelo = modelo;
        this.vista = vista;
        
        
        //Aqui va toda la logica de la controladora
    }
    
    
    
}
