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
 * Representa un rubro comercial, como por ejemplo "Kiosko" o "Carnicería".
 * Un rubro está asociado a una actividad económica, un código, y puede tener
 * requisitos específicos que deben cumplirse al momento de tramitar un expediente.
 */
public class Rubro {
    
    // Atributos
    private int idRubro;
    private String nombre;
    private String descripcion;
    private String actividad;
    private List<Requisito> requisitos;
    private boolean esRubroEspecial;
    private boolean requiereBromatologia;
    private boolean esDeAltoRiesgo;
    

    // Constructor completo
    public Rubro(int idRubro, String nombre,String descripcion,
                 String actividad, List<Requisito> requisitos) {
        this.idRubro = idRubro;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.actividad = actividad;
        this.requisitos = requisitos;
    }

    // Constructor por defecto
    public Rubro() {
    }

    // Getters y setters
    public int getIdRubro() {
        return idRubro;
    }

    public void setIdRubro(int idRubro) {
        this.idRubro = idRubro;
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

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public List<Requisito> getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(List<Requisito> requisitos) {
        this.requisitos = requisitos;
    }
    
    public boolean isEsRubroEspecial() {
    return esRubroEspecial;
    }

    public void setEsRubroEspecial(boolean esRubroEspecial) {
        this.esRubroEspecial = esRubroEspecial;
    }

    public boolean isRequiereBromatologia() {
        return requiereBromatologia;
    }

    public void setRequiereBromatologia(boolean requiereBromatologia) {
        this.requiereBromatologia = requiereBromatologia;
    }


    
    // Lógica que permite saber si el rubro requiere atención especial
    public boolean esRubroEspecial() {
        // Por ejemplo, si en la actividad dice "gastronomía", se lo considera especial
        return actividad != null && actividad.toLowerCase().contains("gastronomía");
    }

    public boolean estaHabilitadoPara(TipoTramite tipoTramite) {
       
        return true; 
    }
    
    public boolean isEsDeAltoRiesgo() {
    return esDeAltoRiesgo;
    }

    public void setEsDeAltoRiesgo(boolean esDeAltoRiesgo) {
        this.esDeAltoRiesgo = esDeAltoRiesgo;
    }
    
    // Devuelve el nombre del rubro cuando se imprime en una lista (combo, etc.)
    public String toString() {
    return nombre;
    }
    // Compara si dos rubros son iguales por ID
    @Override
    public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Rubro that = (Rubro) obj;
    return this.idRubro == that.idRubro;
    }

    @Override
    public int hashCode() {
    return Integer.hashCode(idRubro);
    }

    
}
