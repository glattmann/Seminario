/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaexpedientes.modelo;

import java.util.Date;

/**
 *
 * @author GL
 */
/**
 * Representa una actuación realizada por un sector en relación a un expediente.
 * Básicamente, es como un paso o una acción tomada por un sector sobre el expediente.
 */
public class ActuacionSectorial {

   
    private int idActuacion;  // Identificador único de la actuación (puede servir si lo necesitamos guardar o buscar después)
    private Sector sector; // Sector que está haciendo la actuación (como Comercio, Inspección, etc.)
    private String estado; // Estado actual de la actuación (por ejemplo: Aprobada, Pendiente, Rechazada)
    private String observacion; // Alguna observación o comentario que se quiera dejar sobre la actuación
    private Date fechaHora; // Fecha y hora en que se registró esta actuación
    private Usuario usuarioResponsable; // Usuario que hizo o está a cargo de esta actuación
    private Expediente expediente; // Expediente al cual pertenece esta actuación

    // Constructor vacío, por si necesitamos crear el objeto sin datos al principio
    public ActuacionSectorial() {
    }

    // Constructor con todos los campos. Útil cuando ya tenemos todos los datos desde el principio
    public ActuacionSectorial(int idActuacion, Sector sector, String estado, String observacion,
                               Date fechaHora, Usuario usuarioResponsable, Expediente expediente) {
        this.idActuacion = idActuacion;
        this.sector = sector;
        this.estado = estado;
        this.observacion = observacion;
        this.fechaHora = fechaHora;
        this.usuarioResponsable = usuarioResponsable;
        this.expediente = expediente;
    }

    // Getters y setters de todos los campos para poder acceder y modificar los datos
    public int getIdActuacion() {
        return idActuacion;
    }

    public void setIdActuacion(int idActuacion) {
        this.idActuacion = idActuacion;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Usuario getUsuarioResponsable() {
        return usuarioResponsable;
    }

    public void setUsuarioResponsable(Usuario usuarioResponsable) {
        this.usuarioResponsable = usuarioResponsable;
    }

    public Expediente getExpediente() {
        return expediente;
    }

    public void setExpediente(Expediente expediente) {
        this.expediente = expediente;
    }

    // Devuelve true si la actuación fue aprobada
    public boolean esAprobada() {
        return estado != null && estado.equalsIgnoreCase("Aprobada");
    }

    // Devuelve true si todavía está pendiente
    public boolean estaPendiente() {
        return estado != null && estado.equalsIgnoreCase("Pendiente");
    }

    // Permite registrar o cambiar una observación
    public void registrarObservacion(String obs) {
        this.observacion = obs;
    }
}

