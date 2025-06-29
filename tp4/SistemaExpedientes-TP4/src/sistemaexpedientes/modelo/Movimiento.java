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
public class Movimiento {

    private int idMovimiento; // Identificador único del movimiento
    private Expediente expediente; // El expediente que se está moviendo
    private Sector sectorOrigen; // Sector de donde sale el expediente
    private Sector sectorDestino; // Sector al que va el expediente
    private Date fechaHoraSalida; // Cuándo se envió el expediente
    private Date fechaHoraRecepcion; // Cuándo se recibió en el destino 
    private Usuario usuarioEmisor;  // Usuario que envía el expediente
    private Usuario usuarioReceptor; // Usuario que recibe el expediente

    // Constructor vacío
    public Movimiento() {
    }
    
    // Constructor con todos los datos del movimiento
    public Movimiento(int idMovimiento, Expediente expediente, Sector sectorOrigen, Sector sectorDestino,
                      Date fechaHoraSalida, Date fechaHoraRecepcion,
                      Usuario usuarioEmisor, Usuario usuarioReceptor) {
        this.idMovimiento = idMovimiento;
        this.expediente = expediente;
        this.sectorOrigen = sectorOrigen;
        this.sectorDestino = sectorDestino;
        this.fechaHoraSalida = fechaHoraSalida;
        this.fechaHoraRecepcion = fechaHoraRecepcion;
        this.usuarioEmisor = usuarioEmisor;
        this.usuarioReceptor = usuarioReceptor;
    }

    //Getters y Setters
    public int getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(int idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public Expediente getExpediente() {
        return expediente;
    }

    public void setExpediente(Expediente expediente) {
        this.expediente = expediente;
    }

    public Sector getSectorOrigen() {
        return sectorOrigen;
    }

    public void setSectorOrigen(Sector sectorOrigen) {
        this.sectorOrigen = sectorOrigen;
    }

    public Sector getSectorDestino() {
        return sectorDestino;
    }

    public void setSectorDestino(Sector sectorDestino) {
        this.sectorDestino = sectorDestino;
    }

    public Date getFechaHoraSalida() {
        return fechaHoraSalida;
    }

    public void setFechaHoraSalida(Date fechaHoraSalida) {
        this.fechaHoraSalida = fechaHoraSalida;
    }

    public Date getFechaHoraRecepcion() {
        return fechaHoraRecepcion;
    }

    public void setFechaHoraRecepcion(Date fechaHoraRecepcion) {
        this.fechaHoraRecepcion = fechaHoraRecepcion;
    }

    public Usuario getUsuarioEmisor() {
        return usuarioEmisor;
    }

    public void setUsuarioEmisor(Usuario usuarioEmisor) {
        this.usuarioEmisor = usuarioEmisor;
    }

    public Usuario getUsuarioReceptor() {
        return usuarioReceptor;
    }

    public void setUsuarioReceptor(Usuario usuarioReceptor) {
        this.usuarioReceptor = usuarioReceptor;
    }
     // Este método devuelve true si el expediente todavía no fue recibido
    public boolean estaEnTransito() {
        return fechaHoraRecepcion == null;
    }
    // Marca que el expediente fue recibido por un usuario y guarda la fecha actual
    public void confirmarRecepcion(Usuario usuario) {
        this.usuarioReceptor = usuario;
        this.fechaHoraRecepcion = new Date();
    }
}

