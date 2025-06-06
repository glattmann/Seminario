/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaexpedientes.modelo;

import java.util.List;
/**
 *
 * @author GL
 */
/**
 * Representa el tipo de trámite que puede tener un expediente.
 * Ej: Nueva habilitación, Renovación, etc.
 */
public class TipoTramite {
    
    // Atributos
    private int idTipoTramite;
    private String nombre;
    private String descripcion;
    private List<Requisito> requisitos;

    // Constructor
    public TipoTramite(int idTipoTramite, String nombre, String descripcion, List<Requisito> requisitos) {
        this.idTipoTramite = idTipoTramite;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.requisitos = requisitos;
    }

    // Constructor por defecto
    public TipoTramite() {
    }

    // Getters y setters
    public int getIdTipoTramite() {
        return idTipoTramite;
    }

    public void setIdTipoTramite(int idTipoTramite) {
        this.idTipoTramite = idTipoTramite;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Requisito> getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(List<Requisito> requisitos) {
        this.requisitos = requisitos;
    }

   // Devuelve true si el trámite es del tipo "Nueva habilitación"
    public boolean esNuevaHabilitacion() {
        return nombre != null && nombre.equalsIgnoreCase("Nueva habilitación");
    }

    public boolean requiereInspeccion() {
        
        return esNuevaHabilitacion(); 
    }
    
     // Para mostrar bien el nombre en los comboBox o impresiones
    public String toString() {
    return nombre;
    }
    
    // Se sobrescribe equals para comparar correctamente por id
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        TipoTramite that = (TipoTramite) obj;
        return this.idTipoTramite == that.idTipoTramite;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(idTipoTramite);
    }

    
    
}
