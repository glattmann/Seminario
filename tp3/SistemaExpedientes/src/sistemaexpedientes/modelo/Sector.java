/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaexpedientes.modelo;

/**
 *
 * @author GL
 */
/**
 * Clase abstracta que representa un sector del municipio (como Comercio o Mesa de Entrada).
 * Sirve como base para los sectores concretos que van a tener su propio comportamiento.
 */
public abstract class Sector {
    
    // private int idSector;
    // private String descripcion;
    // private boolean activo;
    protected String nombre; // Nombre del sector (ejemplo: "Comercio", "Mesa de Entrada")

    // Constructor que recibe el nombre del sector
    public Sector(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    // public boolean esTecnico() {
    //     return false;
    // }
    // Método abstracto que obliga a los sectores hijos a implementar qué hacen con un expediente
    public abstract void procesarExpediente(Expediente expediente);
}