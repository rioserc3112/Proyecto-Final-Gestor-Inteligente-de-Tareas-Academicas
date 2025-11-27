/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author emma3
 */
public class Tarea {
    private int id;
    private String tarea;
    private String fecha;
    private String responsable;
    private String estado;
    private String descripcion;

    //Constructor por defecto
    public Tarea(int id){
    this.id = id;
    }
    
    //Constructor sobrecargado
    public Tarea(int id, String tarea, String fecha, String responsable, String estado, String descripcion) {
        this.id = id;
        this.tarea = tarea;
        this.fecha = fecha;
        this.responsable = responsable;
        this.estado = estado;
        this.descripcion = descripcion;
    }

    
    //Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTarea() {
        return tarea;
    }

    public void setTarea(String tarea) {
        this.tarea = tarea;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
    
}

