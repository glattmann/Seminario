/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaexpedientes.modelo;

/**
 * Clase que representa el sector "Mesa de Entrada" en el circuito de tramitación de expedientes.
 * Este sector es el encargado de iniciar el trámite de un expediente al momento de su ingreso.
 * Extiende la clase base Sector.
 *
 * Autor: GL
 */
public class MesaEntrada extends Sector {

    //Constructor
    public MesaEntrada() {
        super("Mesa de Entrada");
    }
    
    // Este método se ejecuta cuando la Mesa de Entrada recibe un expediente.
    // Cambia su estado a "Iniciado" y muestra un mensaje en consola
    @Override
    public void procesarExpediente(Expediente expediente) {
        System.out.println("Mesa de Entrada inicia expediente: " + expediente.getNomenclatura());
        expediente.setEstado("Iniciado");
    }
}
