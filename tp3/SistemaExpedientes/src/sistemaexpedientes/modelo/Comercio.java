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
 * Esta clase representa el sector de Comercio dentro del sistema.
 * Hereda de la clase Sector y sobreescribe el método para procesar un expediente.
 */
public class Comercio extends Sector {

    // Constructor: llama al constructor del padre (Sector) y le pasa el nombre "Comercio"
    public Comercio() {
        super("Comercio");
    }

    /**
     * Este método se llama cuando el expediente pasa por el sector de Comercio.
     * Lo que hace es imprimir en consola que se verificaron los requisitos
     * y agrega una observación al expediente para dejar constancia de eso.
     */
    @Override
    public void procesarExpediente(Expediente expediente) {
        System.out.println("✅ Comercio verifica requisitos del expediente: " + expediente.getNomenclatura());
        expediente.registrarObservacion("Requisitos verificados por Comercio");
    }
}